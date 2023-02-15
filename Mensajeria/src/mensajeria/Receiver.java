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
public class Receiver implements Runnable{
    private Buffer buffer;

    public Receiver(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        for (String receivedMessage = buffer.receive();!"End".equals(receivedMessage);receivedMessage = buffer.receive()) {
            System.out.println(receivedMessage);
            try {
                Thread.sleep((long) (Math.random()*4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
