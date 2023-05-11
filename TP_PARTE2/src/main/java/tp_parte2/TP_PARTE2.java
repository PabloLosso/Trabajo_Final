/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tp_parte2;

import Equipo.Equipo;
import Participante.Participante;
import Partido.Partido;
import Pronostico.Pronostico;
import ResultadoEnum.ResultadoEnum;
import Ronda.Ronda;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TP_PARTE2 {

    public static void main(String[] args) {
 //Listado de partidos------------------------------------------       
     //Leer resultados
        List<Partido> partidos = new ArrayList<Partido>();
        List<Ronda> rondas = new ArrayList<Ronda>();
    
        Path pathResultados = Paths.get (args[0]);
        List<String> lineasResultados = null;
        
            try {
                lineasResultados = Files.readAllLines(pathResultados);
            } catch (IOException ex) {
                System.out.println("No se pudo leer el archivo");
                System.out.println(ex.getMessage());
                System.exit(1);
            }
        
            boolean primera = true;
            for (String lineaResultado : lineasResultados){
                if (primera){
                    primera = false;
                }else{
                String [] campos = lineaResultado.split(",");
            
         //Equipos-Partido   
                Equipo equipo1 = new Equipo(campos[1]);
                Equipo equipo2 = new Equipo(campos[4]);
                Partido partido = new Partido(equipo1, equipo2);
        
         //Goles  
                partido.setGolesEquipo1(Integer.parseInt(campos[2]));
                partido.setGolesEquipo2(Integer.parseInt(campos[3]));
            
         //Resultado
                ResultadoEnum resultadoReal = partido.resultado();
                partido.setResultado(resultadoReal);
                
         //Número de ronda
                partido.setNroDeRonda(campos[0]);
            
         //Lista de partidos
                partidos.add(partido);
                
         //Lista de rondas
                Ronda nroDeRonda = new Ronda(campos[0]);
                if (rondas.isEmpty()){
                    rondas.add(nroDeRonda);
                    }
                for (int d = 0; d < rondas.size(); d++){
                    if(!(rondas.get(d).getRondas().equals(campos[0])) && d == (rondas.size()-1)){
                    rondas.add(nroDeRonda);
                        }
                    }
                }
            }

//Listado de Pronósticos------------------------------------------------------        
     //Leer pronóstico
            List<Pronostico> pronosticosDeportivos = new ArrayList<Pronostico>();
            int puntos = 0;

            Pronostico pronosticoDeportivo = new Pronostico(null, null, null);
            pronosticoDeportivo.setPuntos(puntos);
    
            Path pathPronosticos = Paths.get (args[1]);
            List<String> lineasPronosticos = null;
    
            try {
                lineasPronosticos = Files.readAllLines(pathPronosticos);
            } catch (IOException ex) {
                System.out.println("No se pudo leer el archivo");
                System.out.println(ex.getMessage());
                System.exit(1);
            }
        
        primera = true;
        Participante unParticipante = null;
        
        for (String lineaPronostico : lineasPronosticos){
            if (primera){
                primera = false;
            }else{
                String [] campos = lineaPronostico.split(",");
                
             //Participantes    
                unParticipante = new Participante (campos [0], 0);
            
             //Equipos    
                Equipo equipo1 = new Equipo(campos[2]);
                Equipo equipo2 = new Equipo(campos[6]);
                Partido partido = new Partido(equipo1, equipo2);    //Datos del archivo pronostico.csv
                
             //Pronostico
                ResultadoEnum resultadoPronostico = null;
                if ("X".equals(campos[3])){
                    resultadoPronostico = ResultadoEnum.GANADOR1;
                }
                if ("X".equals(campos[4])){
                    resultadoPronostico = ResultadoEnum.EMPATE;
                }
                if ("X".equals(campos[5])){
                    resultadoPronostico = ResultadoEnum.GANADOR2;
                }
 
                pronosticoDeportivo = new Pronostico (unParticipante, partido, resultadoPronostico);
                pronosticoDeportivo.setNroDeRonda(campos[1]);
                //Faltaría cargar los puntos.
                
             //Lista de pronósticos
                pronosticosDeportivos.add(pronosticoDeportivo);
            }
        }

//Listado de Participantes -------------------------------------------------------------
    List<Participante> jugadores = new ArrayList<Participante>();
    if (jugadores.isEmpty()){
        jugadores.add(pronosticosDeportivos.get(0).getParticipantes());
    }
    for (int j = 0; j < pronosticosDeportivos.size(); j++){
        if( !(j == 0)){
            for (int h = j; h > 0; ){
                if (pronosticosDeportivos.get(j).getParticipantes().getParticipantes().equals(pronosticosDeportivos.get(h-1).getParticipantes().getParticipantes())){
                    h = 0; // Termino el for porque el participante está repetido.
                }else { if (h == 1){
                            jugadores.add(pronosticosDeportivos.get(j).getParticipantes());
                            h = 0;
                        }else{ h--; }   
                }
            }
        }
    }

 //Calculo de puntos----------------------------------------------------------
    ResultadoEnum resultadoPronostico = null;
    String nombre = null;
    
    for (int a = 0; a < jugadores.size(); a++){     //Índice "a" referido a los Participantes 
        int puntosBonus = 0;
        int puntosTotales = 0;
        for (int d = 0; d < rondas.size(); d++ ){   //Índice "d" referido a las Rondas
            int cantDePartidos = 0;
            int puntosPorRonda = 0;
            for (int b = 0; b < pronosticosDeportivos.size(); b++){     //Índice "b" referido a los Pronósticos
                if (jugadores.get(a).getParticipantes().equals(pronosticosDeportivos.
                        get(b).getParticipantes().getParticipantes())
                        &&
                        rondas.get(d).getRondas().equals(pronosticosDeportivos.get(b).getNroDeRonda())){
                    for (int c = 0; c < partidos.size(); c++){          //Índice "c" referido a los Partidos
                        if(pronosticosDeportivos.get(b).getPartido().getEquipo1().getNombre().
                                equals(partidos.get(c).getEquipo1().getNombre())
                            &&
                            pronosticosDeportivos.get(b).getPartido().getEquipo2().getNombre().
                                equals(partidos.get(c).getEquipo2().getNombre())
                            &&
                            rondas.get(d).getRondas().equals(partidos.get(c).getNroDeRonda())){
                        
                            //Inicializo los valores para la clase Pronostico
                            unParticipante = pronosticosDeportivos.get(b).getParticipantes();
                            Partido partido = partidos.get(c);  
                            resultadoPronostico = pronosticosDeportivos.get(b).getResultado();
                        
                            //Calculo los puntos
                            pronosticoDeportivo = new Pronostico (unParticipante, partido, resultadoPronostico); /*
                                Cargando el partido (que contiene el resultado real) y resultado del pronóstico.
                                */
                            puntos = pronosticoDeportivo.puntosObtenidos(); //Llamo al método puntosObtenidos.
                        
                            cantDePartidos++;
                            puntosPorRonda += puntos;
                            
                            pronosticoDeportivo.setPuntos(puntos);
                            pronosticoDeportivo.setNroDeRonda(pronosticosDeportivos.get(b).getNroDeRonda());
                            pronosticosDeportivos.remove(b);
                            pronosticosDeportivos.add(b, pronosticoDeportivo);
                        }
                    }//termina for c
                }      
            }//termina for b
            if (cantDePartidos == puntosPorRonda){
                puntosBonus = 1;
            }else { puntosBonus = 0;}
            
            puntosTotales += puntosPorRonda + puntosBonus;
            
            nombre = jugadores.get(a).getParticipantes();
            jugadores.remove(a);
            Participante actualizarParticipante = new Participante(nombre, puntosTotales);
            jugadores.add(a, actualizarParticipante);
        }//termina for d      
    }//termina for a
 //------------------------------------------------------
        System.out.println();
    
 //Pronósticos
   /* for(int j = 0; j < pronosticosDeportivos.size(); j++){
        System.out.print(pronosticosDeportivos.get(j).getNroDeRonda());
        System.out.print("\t");
        System.out.print(pronosticosDeportivos.get(j).getParticipantes().getParticipantes());
        System.out.print("\t\t"); 
        System.out.print(pronosticosDeportivos.get(j).getPartido().getEquipo1().getNombre());
        if(pronosticosDeportivos.get(j).getPartido().getEquipo1().getNombre().length() < 8){
            System.out.print("\t\t");
        } else{ System.out.print("\t");}
        System.out.print(pronosticosDeportivos.get(j).getPartido().getEquipo2().getNombre());
        if(pronosticosDeportivos.get(j).getPartido().getEquipo2().getNombre().length() < 8){
            System.out.print("\t\t");
        } else{ System.out.print("\t");}
        System.out.print(pronosticosDeportivos.get(j).getResultado());
        if(pronosticosDeportivos.get(j).getResultado().name().length() < 8){
            System.out.print("\t\t");
        } else{ System.out.print("\t");}
        System.out.print("Puntos obtenidos ");
        System.out.print(pronosticosDeportivos.get(j).getPuntos());
        System.out.println();
    }*/
    
 //Puntos Totales
        for(Participante recorrer: jugadores){
            System.out.println(recorrer.getParticipantes() + "\t - Puntos totales obtenidos " + recorrer.getPuntosTotales());
        }
    }
}