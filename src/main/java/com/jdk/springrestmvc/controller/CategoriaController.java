/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.controller;

import com.jdk.springrestmvc.domain.Categoria;
import com.jdk.springrestmvc.domain.Film;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author jdk
 */
@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoriaController {

    List<Categoria> categorie;


    public CategoriaController() {
        cataFilms();
    }

    public void cataFilms() {
       

    }

    @GetMapping(value = "/")
    public List<Categoria> getAllcata() {
        
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCategoria(@PathVariable long id) {
        Categoria search = null;

        for (Categoria c : categorie) {
            if (id == c.getId()) {
                search = c;
                break;
            }
        }

        if (search != null) {
            return new ResponseEntity(search, HttpStatus.OK);
        } else {
            return new ResponseEntity(search, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity creaCate(@RequestBody Categoria categoria, @RequestBody Film film, BindingResult result) {
        Logger.getLogger(CategoriaController.class.getName())
                .log(Level.INFO, categoria.toString());

        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.CONFLICT);
        } else {
            categoria.setId(new Date().getTime());
            this.categorie.add(categoria);
            return new ResponseEntity(categoria,HttpStatus.OK);
        }
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCate(@RequestBody Categoria categoria, BindingResult result) {
        Logger.getLogger(CategoriaController.class.getName())
                .log(Level.SEVERE, categoria.toString());
        Categoria toUpdate = null;

        for (Categoria c : categorie) {
            if (categoria.getId() == c.getId()) {
                toUpdate = c;
                break;
            }
        }

        if (toUpdate != null) {
            toUpdate.setId(categoria.getId());
            toUpdate.setGenere(categoria.getGenere());
            return new ResponseEntity(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity(categoria.getId(), HttpStatus.NO_CONTENT);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletecategoria(@PathVariable Long id) {

        Categoria toDelete = null;
        for (Categoria e : categorie) {
            if (e.getId() == id) {
                toDelete = e;
                break;
            }
        }

        if (toDelete != null) {
            categorie.remove(toDelete);
            return new ResponseEntity(id, HttpStatus.OK);
        } else {
            return new ResponseEntity(id, HttpStatus.NO_CONTENT);
        }
    }

}
