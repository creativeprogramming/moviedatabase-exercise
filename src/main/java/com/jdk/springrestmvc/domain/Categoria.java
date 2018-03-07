/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;


/**
 *
 * @author jdk
 */

@Entity
@Table(name="category")
public class Categoria {
    
    @Id
    @GeneratedValue()
    
    @Column(name="id")
    private long id;
    
    @Column(name="genere")
    private String genere;
    
    @ManyToMany(mappedBy = "Category")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Film> film;
    
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
