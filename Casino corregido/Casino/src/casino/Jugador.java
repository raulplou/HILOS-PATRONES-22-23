/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author S2-PC104
 */
public class Jugador extends Thread {

    private String nombre;
    private double saldoJugador;
    private double saldoApostado;
    private int numApostado;
    private Ruleta ruleta;

    public Jugador(String nombre, Ruleta ruleta) {
        this.nombre = nombre;
        this.saldoJugador = 1000;
        this.saldoApostado = 10;
        this.ruleta = ruleta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldoJugador() {
        return saldoJugador;
    }

    public void setSaldoJugador(double saldoJugador) {
        this.saldoJugador = saldoJugador;
    }

    public double getSaldoApostado() {
        return saldoApostado;
    }

    public void setSaldoApostado(double saldoApostado) {
        this.saldoApostado = saldoApostado;
    }

    public int getNumApostado() {
        return numApostado;
    }

    public void setNumApostado(int numApostado) {
        this.numApostado = numApostado;
    }

    public Ruleta getRuleta() {
        return ruleta;
    }

    public void setRuleta(Ruleta ruleta) {
        this.ruleta = ruleta;
    }

    @Override
    public void run() {

        while (ruleta.getDineroBanca() > 0) {
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ruleta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ruleta.setNumeroRuleta((int) (Math.random() * 36));

            setNumApostado((int) (Math.random() * 36));

            System.out.println("El jugador " + getNombre() + " empieza con " + getSaldoJugador() + "€\n");

            System.out.println("El jugador " + getNombre() + " está apostando....\n");

            System.out.println("El jugador " + getNombre() + " apuesta al " + getNumApostado());

            System.out.println("El número de la ruleta es el " + ruleta.getNumeroRuleta());

            if (ruleta.getNumeroRuleta() == getNumApostado()) {
                setSaldoJugador(getSaldoJugador() + 360);
                System.out.println("El jugador " + getNombre() + " ha acertado el número!!\n");
            } else {
                setSaldoJugador(getSaldoJugador() - getSaldoApostado());
                System.out.println("El jugador " + getNombre() + " ha perdido lo apostado\n");
            }

            if (ruleta.getNumeroRuleta() == 0) {
                setSaldoJugador(getSaldoJugador() - getSaldoApostado());
                ruleta.setDineroBanca(ruleta.getDineroBanca() + getSaldoApostado());
                System.out.println("El jugador " + getNombre() + " ha perdido lo apostado "
                        + "y la Banca se queda con el dinero");
                System.out.println("Dinero de la banca: " + ruleta.getDineroBanca() + "€");
            }

            if (getSaldoJugador() == 0) {
                System.out.println("El jugador " + getNombre() + " no puede seguir jugando");
            }

            System.out.println("El saldo actual del jugador " + getNombre() + " es: " + getSaldoJugador() + "€\n");
        }
        
        System.out.println("BANCARROTA");

    }

}
