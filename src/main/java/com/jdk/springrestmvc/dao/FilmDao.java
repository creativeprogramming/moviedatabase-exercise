/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.dao;

import com.jdk.springrestmvc.domain.Film;
import java.util.List;

/**
 *
 * @author tarek
 */
public interface FilmDao {
    
    public List <Film> getListFilm ();
    
    public void saveOrUpdate (Film film);
    
    public void deleteFilm (long id);
    
    public Film findFilmById (long id);
    
}
