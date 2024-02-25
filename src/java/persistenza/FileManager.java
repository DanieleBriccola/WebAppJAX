/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenza;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author danie
 */
public class FileManager<T> {
    private String filePath = "persistenzaFile.bin";

    public void scrivi(T oggetto) throws IOException { 
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileOutputStream fos = new FileOutputStream(filePath); //con true non sovrascrivi
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(oggetto);
        } 
        
        System.out.println("Scritto tutto");
    }
    
    public void aggiungi(T oggetto) throws IOException { 
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileOutputStream fos = new FileOutputStream(filePath,true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(oggetto);
        } 
    }

    public T leggi() throws IOException{
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (T) ois.readObject();
        }
        catch (IOException e) {
            return null;
        }
        catch (ClassNotFoundException e) {
            return null;
        }
    }
}
