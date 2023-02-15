/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.util.ArrayList;

/**
 *
 * @author S2-PC104
 */
public class Casino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList <Jugador> jugadores = new ArrayList<>();
        
        Ruleta ruleta = new Ruleta(jugadores);
        
        Jugador jugador1 = new Jugador("Lolo",ruleta);
        Jugador jugador2 = new Jugador("Lalo",ruleta);
        Jugador jugador3 = new Jugador("Lelo",ruleta);
        Jugador jugador4 = new Jugador("Lola",ruleta);
        
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        
        
        ruleta.start();
    }
    
}
