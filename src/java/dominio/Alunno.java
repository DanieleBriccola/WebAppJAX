/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;

/**
 *
 * @author danie
 */
public class Alunno implements Serializable {
    
    private String nome;
    private String cognome;
    private Long id;
    
    public Alunno() {
    
    }
    
    public Alunno(String nome, String cognome, Long id){
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
