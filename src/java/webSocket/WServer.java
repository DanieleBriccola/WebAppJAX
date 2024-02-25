/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webSocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.websocket.*;
import javax.websocket.server.*;
import javax.ws.rs.QueryParam;

/**
 *
 * @author danie
 */
@ServerEndpoint("/endpoint")
public class WServer {
    private static final List<Session> listaSessioni = new ArrayList();
    private static final Map<String,String> listaNomi = new HashMap();
    @OnMessage
    public void onMessage(Session sessione, String message) throws IOException {
        for(String nome:listaNomi.values())
            System.out.println("nomi: " + nome);
        for (Session sessioni : listaSessioni) {
            sessioni.getBasicRemote().sendText(listaNomi.get(sessione.getId()) + ":" + message);
        }
        
    }
    
    @OnOpen
    public void onOpen(@PathParam("nomeUtente") String nome,Session sessione) throws IOException{
        System.out.println(nome);
        listaSessioni.add(sessione);
        listaNomi.put(sessione.getId(),nome);
    }
    
    @OnClose
    public void chiudoConnesione(Session sessione) throws IOException{
        System.out.println("Qualcuno ha richiesto di chiudere una connesione " + sessione.getId());
        listaSessioni.remove(sessione);
        listaNomi.remove(sessione.getId());
        for (Session sessioni : listaSessioni) {
            sessioni.getBasicRemote().sendText(sessione.getId() + "Ã© uscito");
        }
    }
    
}
