/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import persistenza.PersistenzaAlunno;
import dominio.Alunno;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author danie
 */
@ApplicationPath("rest")
@Path("ciao")
public class Controllore extends Application {
    private static PersistenzaAlunno persistenzaAlunno = new PersistenzaAlunno();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response onGet(){
        GenericEntity<List<Alunno>> elenco = new GenericEntity<List<Alunno>>(persistenzaAlunno.listAll()) {};
        for(Alunno alunno : persistenzaAlunno.listAll()){
            System.out.println(alunno.getCognome());
        }
        return Response.ok(elenco).build();
    }
    
    @GET
    @Path("read")
    public Response onGetJson(@QueryParam("nome") String nome){
        return Response.ok(nome).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response onPostJson(Alunno alunno) throws IOException{
        System.out.println("creato: " + alunno.getCognome());
        persistenzaAlunno.create(alunno, alunno.getId());
        persistenzaAlunno.scriviFile();
        return Response.ok().build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response onPutJson(Alunno alunno){
        persistenzaAlunno.update(alunno, alunno.getId());
        return Response.ok().build();
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response onDeleteJson(Alunno alunno){
        persistenzaAlunno.delete(alunno.getId());
        return Response.ok().build();
    }
}
