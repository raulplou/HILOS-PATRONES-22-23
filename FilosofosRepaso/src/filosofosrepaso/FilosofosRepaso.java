/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofosrepaso;

/**
 *
 * @author rplou
 */
public class FilosofosRepaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mesa m = new Mesa(5);

        for (int i = 1; i <= 5; i++) {
            Filosofo f = new Filosofo(m, i);
            new Thread(f).start();
        }
    }

}
