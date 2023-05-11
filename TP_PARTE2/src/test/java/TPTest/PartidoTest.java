/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPTest;

import Equipo.Equipo;
import Partido.Partido;
import static ResultadoEnum.ResultadoEnum.GANADOR1;
import static ResultadoEnum.ResultadoEnum.GANADOR2;
import static ResultadoEnum.ResultadoEnum.EMPATE;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

/**
 *
 * @author Usuario
 */
public class PartidoTest {
    
    @Test
    public void ResultadoDelPartidoGanadorEquipo1(){
        
        Equipo equipo1 = new Equipo ("Alemania");
        Equipo equipo2 = new Equipo ("Italia");
        Partido partidoSemifinal = new Partido (equipo1, equipo2);
        
        partidoSemifinal.setGolesEquipo1(2);
        partidoSemifinal.setGolesEquipo2(1);
        //partidoSemifinal.setNroDeRonda("1");
        //partidoSemifinal.setResultado(GANADOR1);
        
        Assertions.assertEquals(GANADOR1, partidoSemifinal.resultado());
        
    }
    
}
