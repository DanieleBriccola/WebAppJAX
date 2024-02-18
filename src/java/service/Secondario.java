/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author danie
 */
@Path("Prova")
public class Secondario {
    @GET
    @Path("ok")
    public Response onGet(){
        return Response.ok("tutto OK").build();
    }
}
