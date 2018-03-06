package com.jdk.springrestmvc.controller;

import com.jdk.springrestmvc.domain.Categoria;
import com.jdk.springrestmvc.domain.Film;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")
@CrossOrigin
public class FilmController {
    
    @Autowired
    FilmService service;

    public FilmController() {
        listaFilms();
        
    }

    public void listaFilms() {
        films = new ArrayList<Film>();
        Categoria categoria[] = new Categoria[3];
        categoria[0] = new Categoria(1, "Fantascienza");
        categoria[1] = new Categoria(2, "Avventura");
        categoria[2] = new Categoria(3, "Supereoi");
        films.add(new Film(1, "Mass effect", "storia di un comandante della Normandy SR-2"));
        films.add(new Film(2, "Metal Gear Solid", "spionaggio internazionale"));
        films.add(new Film(3, "Batman Begins", "le origini del cavaliere oscuro"));

    }

    @GetMapping(value = "/")
    public List<Film> getLista() {
        return films;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getFilm(@PathVariable long id) {
        Film cerca = null;

        for (Film f : films) {
            if (id == f.getId()) {
                cerca = f;
                break;
            }
        }

        if (cerca != null) {
            return new ResponseEntity(cerca, HttpStatus.OK);
        } else {
            return new ResponseEntity(cerca, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Film creaFilm(@RequestBody Film film) {
            service.saveOrUpdate(film)
            return film;
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateFilm(@RequestBody Film film, BindingResult result) {
        java.util.logging.Logger.getLogger(FilmController.class.getName()).log(Level.INFO, film.toString());
        Film toModificare=null;
                for(Film f: films){
                    if(film.getId()==f.getId()){
                        toModificare=f;
                        break;
                    }
                }
                if(toModificare!=null){
                    Categoria categoria = film.getCategory();
                    categoria.setId(categoria.getId());
                    categoria.setGenere(categoria.getGenere());
                    toModificare.setId(film.getId());
                    toModificare.setNome(film.getNome());
                    toModificare.setDescrizione(film.getDescrizione());
                    toModificare.setCategory(categoria);
                    return new ResponseEntity(film, HttpStatus.OK);
                }else{
                    return new ResponseEntity(film, HttpStatus.NO_CONTENT);
                }
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity deleteFilm(@PathVariable long id){
        Film toDelete=null;
        for(Film e : films){
            if(e.getId()==id){
                toDelete=e;
                break;
            }
        }
        
        if(toDelete!=null){
            films.remove(toDelete);
            return new ResponseEntity(id, HttpStatus.OK);
        }else{
            return new ResponseEntity(id,HttpStatus.NO_CONTENT);
        }
    }
    

}
