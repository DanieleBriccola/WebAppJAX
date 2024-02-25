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
public class tWorld implements Runnable {

    Semaforo semaforo;

    public tWorld(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        for (int a = 0; a < 10;) {
            synchronized (semaforo) {
                if (semaforo.getSemaforo() == Semaforo.semaforo.World) {
                    System.out.println("world");
                    a++;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(tWorld.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    semaforo.changeSemaforo();
                }
            }
        }
    }

}
