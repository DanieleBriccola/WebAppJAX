/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenza;

import dominio.Utente;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author danie
 */
public class PersistenzaUtente extends Persistenza<String,Utente>{
    private static Map<String,Utente> listaAlunni = new HashMap<>();
    
    public PersistenzaUtente() throws IOException, ClassNotFoundException {
        
    }
    @Override
    protected Map<String,Utente> setLista() {
        return listaAlunni;
    }

    @Override
    protected String generateNewKey() {
        return "";
    }
}
