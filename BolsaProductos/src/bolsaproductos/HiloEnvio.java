/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsaproductos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rplou
 */
public class HiloEnvio extends Thread {

    private Bolsa bolsa;

    public HiloEnvio(Bolsa bolsa) {
        super();
        this.bolsa = bolsa;
    }

    @Override
    public void run() {
        if (bolsa.estaLlena() != true) {

            try {
                synchronized (bolsa) {
                    bolsa.wait();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloEnvio.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Enviando la bolsa con " + bolsa.getSize() + " productos");
        }

    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

}
