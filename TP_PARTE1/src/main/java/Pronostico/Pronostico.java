/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pronostico;

import Partido.Partido;
import ResultadoEnum.ResultadoEnum;

/**
 *
 * @author Usuario
 */
public class Pronostico {
    private Partido partido;
    private ResultadoEnum resultado;
    private int puntos;

// constructor    
    public Pronostico(Partido partido, ResultadoEnum resultado) {    
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
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }    
}
