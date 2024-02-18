/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenza;

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

    public Persistenza() {
        lista = setLista();
    }

    public void create(Value value, Key key) {
        if (key == null) {
            Key newKey = generateNewKey();
            lista.put(newKey, value);
        } else {
            lista.put(key, value);
        }
    }

    public Value read(Key key) {
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

    protected abstract Key generateNewKey();

}
