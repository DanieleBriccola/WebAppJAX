/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenza;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author danie
 */
public abstract class Persistenza<Key, Value> {

    private Map<Key, Value> lista;

    protected abstract Map<Key, Value> setLista();

    public Persistenza() throws IOException, ClassNotFoundException {
        FileManager<Map<Key, Value>> fileManager = new FileManager();
        
        lista = setLista();
        lista = fileManager.leggi();
        if(lista == null){
            lista = new HashMap();
        }
    }

    public void create(Value value, Key key){
        if (key == null) {
            Key newKey = generateNewKey();
            lista.put(newKey, value);
        } else {
            lista.put(key, value);
        }
        FileManager<Map<Key,Value>> fileManager = new FileManager();
        try {
            fileManager.scrivi(lista);
        }
        catch(IOException e){
            
        }
    }

    public Value read(Key key) {
        if (key == null) {
            System.out.println("La chiave non puo essere null");
            return null;
        }
        return lista.get(key);
    }

    public void update(Value value, Key key) {
        lista.replace(key, value);
    }

    public void delete(Key key) {
        lista.remove(key);
    }

    public List<Value> listAll() {
        return new ArrayList<Value>(lista.values());
    }

    public void scriviFile() throws IOException {
        FileManager<Map<Key, Value>> fileManager = new FileManager();
        fileManager.scrivi(lista);
    }

    public Map<Key, Value> leggiFile() throws IOException, ClassNotFoundException {
        FileManager<Map<Key, Value>> fileManager = new FileManager();
        return fileManager.leggi();
    }

    protected abstract Key generateNewKey();

}
