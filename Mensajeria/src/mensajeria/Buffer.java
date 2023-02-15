/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rplou
 */
public class Buffer {
    private String packet;
    private boolean puedoEnviar = true;
    
    public synchronized void sender(String packet){
        while (!puedoEnviar) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        puedoEnviar = false;
        this.packet = packet;
        notifyAll();
    }
    
    public synchronized String receive(){
        while (puedoEnviar) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        puedoEnviar = true;
        String returnPacket = this.packet;
        notifyAll();
        return returnPacket;
    }
}
