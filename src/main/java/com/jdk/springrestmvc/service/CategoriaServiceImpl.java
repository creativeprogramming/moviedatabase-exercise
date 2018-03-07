/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.service;

import com.jdk.springrestmvc.dao.CategoriaDao;
import com.jdk.springrestmvc.dao.FilmDao;
import com.jdk.springrestmvc.domain.Categoria;
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
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaDao CatDao;

    public void setFilmDao(CategoriaDao catdao) {
        this.CatDao = catdao;
    }

    @Override
    public List<Categoria> getListCategoria() {
        return CatDao.getListCategoria();
    }

    @Override
    public void saveOrUpdate(Categoria categoria) {
        CatDao.saveOrUpdate(categoria);
    }

    @Override
    public void deleteCategoria(long id) {
        CatDao.deleteCategoria(id);
    }

    @Override
    public Categoria findCategoriaById(long id) {
        return CatDao.findCatById(id);
    }
}
