/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Partido;

import Equipo.Equipo;
import ResultadoEnum.ResultadoEnum;

/**
 *
 * @author Usuario
 */
public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private ResultadoEnum resultado;

//Constructor
    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

//Método resultado
        public ResultadoEnum resultado(){
        if (golesEquipo1 > golesEquipo2){
            return ResultadoEnum.GANADOR1;
        } else {
            if (golesEquipo1 < golesEquipo2){
            return ResultadoEnum.GANADOR2;
            } else {
                return ResultadoEnum.EMPATE;
            }            
        }
    }
    
//Getter y setter
    public Equipo getEquipo1() {
        return equipo1;
    }
    
    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }
}
