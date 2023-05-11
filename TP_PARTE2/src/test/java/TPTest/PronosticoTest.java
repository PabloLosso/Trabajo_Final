/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPTest;

import Equipo.Equipo;
import Participante.Participante;
import Partido.Partido;
import Pronostico.Pronostico;
import static ResultadoEnum.ResultadoEnum.EMPATE;
import org.junit.Test;
import static ResultadoEnum.ResultadoEnum.GANADOR1;
import static ResultadoEnum.ResultadoEnum.GANADOR2;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author Usuario
 */
public class PronosticoTest {
    
    @Test
    public void ObtengoUnPuntoSegunElPronostico(){
        Participante unParticipante = new Participante ("Pablo", 0);
        
        Equipo equipo1 = new Equipo("Argentina");
        Equipo equipo2 = new Equipo("Polonia");
        Partido unPartido = new Partido (equipo1, equipo2);
        unPartido.setGolesEquipo1(2);
        unPartido.setGolesEquipo2(0);
        unPartido.setResultado(GANADOR1);
        
        Pronostico pronosticoDePablo = new Pronostico(unParticipante, unPartido,GANADOR1 );
        
        Assertions.assertEquals(1, pronosticoDePablo.puntosObtenidos());
        
        
        
    }
    
    @Test
    public void NoObtengoPuntosSegunElPronostico(){
       
        Participante unParticipante = new Participante ("Pablo", 0);
        
        Equipo equipo1 = new Equipo("Argentina");
        Equipo equipo2 = new Equipo("Polonia");
        Partido unPartido = new Partido (equipo1, equipo2);
        unPartido.setGolesEquipo1(2);
        unPartido.setGolesEquipo2(0);
        unPartido.setResultado(GANADOR1);
        
        Pronostico pronosticoDePablo = new Pronostico(unParticipante, unPartido,GANADOR2 );
        
        Assertions.assertEquals(0, pronosticoDePablo.puntosObtenidos());
    }
    
}
