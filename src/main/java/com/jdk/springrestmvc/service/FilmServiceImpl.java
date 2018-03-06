/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.service;

import com.jdk.springrestmvc.dao.FilmDao;
import com.jdk.springrestmvc.domain.Film;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tarek
 */
@Service
@Transactional
public class FilmServiceImpl implements FilmService{
    
    FilmDao filmDao;

    
    @Autowired
    public void setFilmDao(FilmDao filmDao) {
        this.filmDao = filmDao;
    }
    
    public List <Film> getListFilm (){
        return filmDao.getListFilm();
    }
    
    public void saveOrUpdate (Film film){
         filmDao.saveOrUpdate(film);
    }
    
    public void deleteFilm (int id){
        filmDao.deleteFilm(id);
    }
    
    public Film findFilmById (int id){
        return filmDao.findFilmById(id);
    }
}
