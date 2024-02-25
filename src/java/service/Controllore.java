/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dominio.Utente;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import persistenza.PersistenzaUtente;

/**
 *
 * @author danie
 */
@ApplicationPath("ws")
@Path("utenti")
public class Controllore extends Application {

    private static PersistenzaUtente persistenzaUtente;

    static {
        try {
            persistenzaUtente = new PersistenzaUtente();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Errore durante l'inizializzazione di PersistenzaUtente", e);
        }
    }

    @POST
    @Path("signUp")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response signUpForm(@FormParam("nickName") String nome, @FormParam("password") String password) throws IOException {
        Utente utente = new Utente(nome,password);
        System.out.println("nome: " + utente.getNome() + " cognome: " + utente.getPassWord());
        persistenzaUtente.create(utente, utente.getNome());
        return Response.ok("Utente Creato").build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response loginForm(@FormParam("nickName") String nome, @FormParam("password") String password) {
        System.out.println("nome: " + nome + " cognome: " + password);

        if (persistenzaUtente == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        Utente utenteTemp = persistenzaUtente.read(nome);
        if(utenteTemp == null){
          return Response.status(Response.Status.FORBIDDEN).build();  
        }
        if (!utenteTemp.getPassWord().equals(password)) {
            System.out.println("UtentePassword: " + utenteTemp.getPassWord() + " -- " + password);
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        URI nextPageUri = UriBuilder.fromPath("http://localhost:8080/ws/chat.jsp").queryParam("nome", utenteTemp.getNome()).build();
        return Response.seeOther(nextPageUri).build();
    }
    
    @GET
    @Path("Utenti")
    public Response TuttiGliUtenti() {
        GenericEntity<List<Utente>> elenco = new GenericEntity<List<Utente>>(persistenzaUtente.listAll()) {
        };
        return Response.ok(elenco).build();
    }

}
