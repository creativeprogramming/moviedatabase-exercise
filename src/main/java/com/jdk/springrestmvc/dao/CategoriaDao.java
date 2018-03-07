/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdk.springrestmvc.dao;

import com.jdk.springrestmvc.domain.Categoria;
import java.util.List;

/**
 *
 * @author jdk
 */
public interface CategoriaDao {
    
    public List<Categoria> getListCategoria();
    
    public void saveOrUpdate(Categoria categoria);
    
    public void deleteCategoria(long id);
    
    public Categoria findCatById(long id);
    
}
