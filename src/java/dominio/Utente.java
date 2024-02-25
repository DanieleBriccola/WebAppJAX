/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danie
 */
@XmlRootElement
public class Utente implements Serializable {
    
    private String nickName;
    private String passWord;
    
    public Utente() {
    
    }
    
    public Utente(String nickName, String passWord){
        this.nickName = nickName;
        this.passWord = passWord;
    }

    public String getNome() {
        return nickName;
    }

    public void setNome(String nickName) {
        this.nickName = nickName;
    }
   
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }
    
    
}
