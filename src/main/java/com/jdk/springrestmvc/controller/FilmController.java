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

    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Film> getListFilm(@RequestBody Film film) {
        List<Film> films = service.getListFilm();
        return films;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Film creaFilm(@RequestBody Film film) {
        service.saveOrUpdate(film);
        return film;
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Film updateFilm(@RequestBody Film film, @PathVariable("id") int id,
            @PathVariable("descrizione") String descrizione,
            @PathVariable("dnome") String nome) {
        film.setDescrizione(descrizione);
        film.setNome(nome);
        service.saveOrUpdate(film);
        return film;
    }

    @DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Film deleteFilm(@PathVariable("id") int id) {
        Film film = service.findFilmById(id);
        service.deleteFilm(id);
        return film;
    }

}
