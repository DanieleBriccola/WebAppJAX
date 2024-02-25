/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class tHello extends Thread {

    Semaforo semaforo;

    public tHello(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        for (int a = 0; a < 10; a++) {
            synchronized (semaforo) {
                if (semaforo.getSemaforo() == Semaforo.semaforo.Hello) {
                    System.out.print("Hello");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(tHello.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    semaforo.changeSemaforo();
                }
            }

        }
    }

}
