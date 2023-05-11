/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tp_parte1;

import Partido.Partido;
import Equipo.Equipo;
import Pronostico.Pronostico;
import ResultadoEnum.ResultadoEnum;
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
public class TP_PARTE1 {

    public static void main(String[] args) {
        
     //Leer resultados
        List<Partido> partidos = new ArrayList<Partido>();
    
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
                Equipo equipo1 = new Equipo(campos[0]);
                Equipo equipo2 = new Equipo(campos[3]);
                Partido partido = new Partido(equipo1, equipo2);
        
         //Goles  
                partido.setGolesEquipo1(Integer.parseInt(campos[1]));
                partido.setGolesEquipo2(Integer.parseInt(campos[2]));
            
         //Resultado
                ResultadoEnum resultadoReal = partido.resultado();
                partido.setResultado(resultadoReal);
            
         //Lista de partidos
                partidos.add(partido);  
                }
            }
        
         //Leer pronóstico
            List<Pronostico> pronosticosDeportivos = new ArrayList<Pronostico>();
            int puntos = 0;
            int puntosTotales = 0;
    
            Pronostico pronosticoDeportivo = new Pronostico(null, null);
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
        Partido partido = new Partido (null, null);
        
        for (String lineaPronostico : lineasPronosticos){
            if (primera){
                primera = false;
            }else{
                String [] campos = lineaPronostico.split(",");
                
             //Equipos    
                Equipo equipo1 = new Equipo(campos[0]);
                Equipo equipo2 = new Equipo(campos[4]);
                
             //Pronostico
                ResultadoEnum resultadoPronostico = null;
                if ("X".equals(campos[1])){
                    resultadoPronostico = ResultadoEnum.GANADOR1;
                }
                if ("X".equals(campos[3])){
                    resultadoPronostico = ResultadoEnum.GANADOR2;
                }
                if ("X".equals(campos[2])){
                    resultadoPronostico = ResultadoEnum.EMPATE;
                }

             //Determinar puntos obtenidos    
                boolean bandera = true;
                int i =0;
                
                while (bandera){
                    if(equipo1.getNombre().equals(partidos.get(i).getEquipo1().getNombre()) &&
                            equipo2.getNombre().equals(partidos.get(i).getEquipo2().getNombre())){
                        
                        partido = partidos.get(i);
                        
                     //Calculo los puntos
                        pronosticoDeportivo = new Pronostico (partido, resultadoPronostico); /*
                                Cargando el partido (que contiene el resultado real) y resultado del pronóstico.
                                */
                        puntos = pronosticoDeportivo.puntosObtenidos(); //Llamo al método puntosObtenidos.
                        puntosTotales = puntos + puntosTotales;
                        
                        bandera = false;
                    } else {
                        i++;
                    }
                }               

                partido = new Partido(equipo1, equipo2);    //Datos del archivo pronostico.csv
                pronosticoDeportivo = new Pronostico (partido, resultadoPronostico);
                
                pronosticoDeportivo.setPuntos(puntos);
                
             //Lista de pronósticos
                pronosticosDeportivos.add(pronosticoDeportivo);
            }
        }
        
     //Mostrar los puntos
        System.out.println("Los puntos totales obtenidos son: " + puntosTotales);
        System.out.println();
    
        for(int j = 0; j < partidos.size(); j++){
            System.out.println(partidos.get(j).getEquipo1().getNombre() + " " + partidos.get(j).getGolesEquipo1() + " " 
                    + partidos.get(j).getEquipo2().getNombre() + " " + partidos.get(j).getGolesEquipo2()
                                + " " + partidos.get(j).getResultado());
        }
        System.out.println();
    
        for(int j = 0; j < pronosticosDeportivos.size(); j++){
            System.out.println(pronosticosDeportivos.get(j).getPartido().getEquipo1().getNombre() + " " +
               pronosticosDeportivos.get(j).getPartido().getEquipo2().getNombre() + " " +
               pronosticosDeportivos.get(j).getResultado() + " " + "Puntos obtenidos " + 
               pronosticosDeportivos.get(j).getPuntos()); 
        }
    }
}
