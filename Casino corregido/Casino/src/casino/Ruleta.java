/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author S2-PC104
 */
public class Ruleta extends Thread {

    private double dineroBanca = 50000;
    private int numeroRuleta;

    private ArrayList<Jugador> jugadores = new ArrayList<>();

    public Ruleta(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public double getDineroBanca() {
        return dineroBanca;
    }

    public void setDineroBanca(double dineroBanca) {
        this.dineroBanca = dineroBanca;
    }

    public int getNumeroRuleta() {
        return numeroRuleta;
    }

    public void setNumeroRuleta(int numeroRuleta) {
        this.numeroRuleta = numeroRuleta;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public void run() {
        for (Jugador jugador : jugadores) {
            jugador.start();
        }

    }
}
