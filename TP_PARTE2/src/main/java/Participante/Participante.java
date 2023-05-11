/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Participante;

/**
 *
 * @author Usuario
 */
public class Participante {
    private String participantes;
    private int puntosTotales;
    

//Constructor

    public Participante(String participantes, int puntosTotales) {
        this.participantes = participantes;
        this.puntosTotales = puntosTotales;
    }
    
    
//Getter y setter 

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }
    
    
}
