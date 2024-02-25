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
public class Semaforo {
    
    public static enum semaforo {
        Hello,
        World
    }
    
    private semaforo statoSemaforo = semaforo.Hello;
    public synchronized semaforo getSemaforo()
    {
        return statoSemaforo;
    }
    
    public synchronized void changeSemaforo()
    {
        if(statoSemaforo == semaforo.Hello)
            statoSemaforo = semaforo.World;
        else 
            statoSemaforo = semaforo.Hello;
    }
    
       
}
