/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.controller;

import com.jdk.springrestmvc.domain.Categoria;
import com.jdk.springrestmvc.domain.Film;
import com.jdk.springrestmvc.service.CategoriaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired 
    CategoriaService service;
    
    public CategoriaController() {
        cataFilms();
    }

    public void cataFilms() {
       

    }

    @GetMapping(value = "/")
    public List<Categoria> getAllcata() {
        List <Categoria> categoria = service.getListCategoria();
        return categoria;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity creaCate(@RequestBody Categoria categoria,  BindingResult result) {
       service.saveOrUpdate(categoria);
       return new ResponseEntity(categoria, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCate(@RequestBody Categoria categoria,BindingResult result, @PathVariable ("id") long id) {
        //categoria = service.findCategoriaById(id);
        categoria.setGenere(categoria.getGenere());
        categoria.setId(id);
        service.saveOrUpdate(categoria);
        return new ResponseEntity(categoria, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletecategoria(@RequestBody Categoria categoria,@PathVariable long id) {
       service.deleteCategoria(id);
       return new ResponseEntity(categoria, HttpStatus.OK);
    }
}
