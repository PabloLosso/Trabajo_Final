/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pronostico;

import Participante.Participante;
import Partido.Partido;
import ResultadoEnum.ResultadoEnum;

/**
 *
 * @author Usuario
 */
public class Pronostico {
    private Participante participantes;
    private Partido partido;
    private ResultadoEnum resultado;
    private String nroDeRonda;
    private int puntos;

// constructor    
    public Pronostico(Participante participantes, Partido partido, ResultadoEnum resultado) {
        this.participantes = participantes;
        this.partido = partido;
        this.resultado = resultado;
    }
    

//Método puntos
    public int puntosObtenidos (){
        ResultadoEnum resultadoReal = this.partido.resultado();
        if (this.resultado.equals(resultadoReal)){
            return 1;
        }else {
        return 0;
        }
    }
    
//Getter
    public Partido getPartido() {
        return partido;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

//Getter y setter   

    public Participante getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Participante participantes) {
        this.participantes = participantes;
    }
    
    
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }  

    public String getNroDeRonda() {
        return nroDeRonda;
    }

    public void setNroDeRonda(String nroDeRonda) {
        this.nroDeRonda = nroDeRonda;
    }
    
}
