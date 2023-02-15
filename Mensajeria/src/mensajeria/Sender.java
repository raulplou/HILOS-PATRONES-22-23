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
public class Sender implements Runnable {
    private Buffer buffer;

    public Sender(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        String packets[] = {
            "First packet",
            "Second packet",
            "Third packet",
            "Fourth packet",
            "End"
        };
        
        for (String packet : packets) {
            buffer.sender(packet);
            
            try {
                Thread.sleep((long) (Math.random()*4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
