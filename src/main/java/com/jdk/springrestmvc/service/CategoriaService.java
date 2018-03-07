/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.service;

import com.jdk.springrestmvc.domain.Categoria;
import java.util.List;

/**
 *
 * @author tarek
 */
public interface CategoriaService {

    public List<Categoria> getListCategoria();

    public void saveOrUpdate(Categoria categoria);

    public void deleteCategoria(long id);

    public Categoria findCategoriaById(long id);

}
