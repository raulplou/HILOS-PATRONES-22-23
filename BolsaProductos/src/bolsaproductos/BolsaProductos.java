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
public class BolsaProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Bolsa bolsa = new Bolsa();
        HiloEnvio hilo = new HiloEnvio(bolsa);
        hilo.start();

        for (int i = 0; i <= 10; i++) {
            Producto p = new Producto();
            try {
                synchronized (bolsa) {
                    Thread.sleep(1000);
                    if (bolsa.estaLlena()) {
                        bolsa.notify();
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(BolsaProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            bolsa.addProducto(p);
            System.out.println(bolsa.getSize());
        }

    }

}
