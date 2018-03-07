package com.jdk.springrestmvc.controller;

import com.jdk.springrestmvc.domain.Categoria;
import com.jdk.springrestmvc.domain.Film;
import com.jdk.springrestmvc.service.FilmService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")
@CrossOrigin
public class FilmController {

    @Autowired
    FilmService service;

    @GetMapping(value = "/")
    public @ResponseBody
    List<Film> getListFilm() {
        List<Film> films = service.getListFilm();
        return films;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Film creaFilm(@RequestBody Film film) {
        service.saveOrUpdate(film);
        return film;
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Film updateFilm(@RequestBody Film film, @PathVariable(value = "id") long id) {
        service.findFilmById(id);
        film.setNome(film.getNome());
        film.setDescrizione(film.getDescrizione());
        film.setId(id);
        service.saveOrUpdate(film);
        return film; 
    }

    @DeleteMapping(value = "/{id}")
    public Film deleteFilm(@PathVariable(value = "id")
    long id) {
        Film film = service.findFilmById(id);
        service.deleteFilm(id);
        return film;
    }
    

}
