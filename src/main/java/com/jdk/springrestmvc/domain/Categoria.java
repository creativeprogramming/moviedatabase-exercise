/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.domain;

import java.util.List;

/**
 *
 * @author jdk
 */
public class Categoria {
    private long id;
    private String genere;
    private List<Film> films;
    
    public Categoria(){}
    
    public Categoria(long id, String genere){
        this.id=id;
        this.genere=genere;
        
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the genere
     */
    public String getGenere() {
        return genere;
    }

    /**
     * @param genere the genere to set
     */
    public void setGenere(String genere) {
        this.genere = genere;
    }


}
