/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.*;
import javax.websocket.server.*;

/**
 *
 * @author danie
 */
@ServerEndpoint("/ws")
public class WServer {
    private static final List<Session> listaSessioni = new ArrayList();
    
    @OnMessage
    public void onMessage(Session sessione, String message) throws IOException {
        System.out.println("Ho ricevuto un messaggio: " + message);
        for (Session sessioni : listaSessioni) {
            sessioni.getBasicRemote().sendText(sessione.getId() + ":" + message);
        }
        
    }
    
    @OnOpen
    public void onOpen(Session sessione) throws IOException{
        System.out.println("Qualcuno Ha fatto accesso " + sessione.getId());
        listaSessioni.add(sessione);
        System.out.println("Lista Sessioni Rimaste");
        for (Session sessioni : listaSessioni) {
            System.out.println(sessioni.getId());
        }
    }
    
    @OnClose
    public void chiudoConnesione(Session sessione) throws IOException{
        System.out.println("Qualcuno ha richiesto di chiudere una connesione " + sessione.getId());
        listaSessioni.remove(sessione);
        for (Session sessioni : listaSessioni) {
            sessioni.getBasicRemote().sendText(sessione.getId() + "Ã© uscito");
        }
    }
    
}
