/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

/**
 *
 * @author rplou
 */
public class Mensajeria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        
        Thread sender = new Thread(new Sender(buffer));
        Thread receiver = new Thread(new Receiver(buffer));
        
        sender.start();
        receiver.start();
    }
    
}
