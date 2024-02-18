/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenza;

import dominio.Alunno;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author danie
 */
public class PersistenzaAlunno extends Persistenza<Long,Alunno>{
    private static Map<Long,Alunno> listaAlunni = new HashMap<>();
    
    @Override
    protected Map<Long, Alunno> setLista() {
        return listaAlunni;
    }

    @Override
    protected Long generateNewKey() {
        Random random = new Random();
        return random.nextLong();
    }
}
