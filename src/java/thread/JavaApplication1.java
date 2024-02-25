/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author danie
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Semaforo semaforo = new Semaforo();
        tHello treadH = new tHello(semaforo);
       
        
        tWorld RunnableW = new tWorld(semaforo);
        Thread treadW = new Thread(RunnableW);
        treadH.start();
        treadW.start();
    }
    
}
