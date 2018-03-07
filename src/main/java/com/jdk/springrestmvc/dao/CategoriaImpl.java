/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.dao;

import com.jdk.springrestmvc.domain.Categoria;
import java.util.List;
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
public class CategoriaImpl  implements CategoriaDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Categoria> getListCategoria() {
        return sessionFactory.getCurrentSession().createQuery("from category ").list();
    }

    @Override
    public void saveOrUpdate(Categoria categoria) {
       sessionFactory.getCurrentSession().saveOrUpdate(categoria);
    }

    @Override
    public void deleteCategoria(long id) {
       Categoria categoria= (Categoria) getSession().get(Categoria.class, id);
          if (categoria != null) {
            sessionFactory.getCurrentSession().delete(categoria);

        }
    }

    @Override
    public Categoria findCatById(long id) {
        Categoria categoria = (Categoria) sessionFactory
                .getCurrentSession().get(Categoria.class, id);
        return categoria;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
                
    }
    
}
