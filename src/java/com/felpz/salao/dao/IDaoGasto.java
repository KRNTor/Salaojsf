/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Gasto;
import java.util.List;

/**
 *
 * @author Felps
 */
public interface IDaoGasto extends IDaoGeneric<Gasto> {
    
    void remover(Gasto compra) throws Exception;
    
    List<Gasto> listarAll() throws Exception;
    
}
