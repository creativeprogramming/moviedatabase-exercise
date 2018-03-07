/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.domain;

import java.util.List;
import com.jdk.springrestmvc.domain.Categoria;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jdk
 */
@Entity
@Table(name="film")
public class Film {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
     @Column(name="nome")
    private String nome;
      @Column(name="descrizione")
    private String descrizione;
    
    @ManyToOne
    private Categoria Category;
  
    
    public Film(){}
    
    public Film(int id, String nome, String descrizione){
        this.id=id;
        this.nome=nome;
        this.descrizione=descrizione;
        
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
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Categoria getCategory() {
        return Category;
    }

    public void setCategory(Categoria Category) {
        this.Category = Category;
    }

    /**
     * @return the categoria
     */
   

    
    
    
}
