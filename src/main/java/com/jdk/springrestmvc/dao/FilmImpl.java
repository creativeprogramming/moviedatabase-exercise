/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.dao;

import com.jdk.springrestmvc.domain.Film;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jdk
 */
@Repository
@Transactional
public class FilmImpl implements FilmDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Film> getListFilm() {
        return sessionFactory.getCurrentSession().createQuery("from Film").list();
    }

    @Override
    public void saveOrUpdate(Film film) {
        sessionFactory.getCurrentSession().save(film);
    }

    @Override
    public void deleteFilm(long id) {
        Film film= (Film) getSession().get(Film.class, id);
        if(film != null){
             sessionFactory.getCurrentSession().delete(film);
   
    }}
    
    @Override
    public Film findFilmById(long id) {
        Film film = (Film) sessionFactory
                .getCurrentSession().get(Film.class, id);
        return film;
    }

    /**
     * @return the sessionFactory
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
