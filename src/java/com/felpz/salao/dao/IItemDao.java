/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Item;
import java.util.List;

/**
 *
 * @author Felps
 */
public interface IItemDao extends IDaoGeneric<Item> {

    public List<Item> listarAll() throws Exception;

    public List<Item> listarAllByName(String nome) throws Exception;

    public Item buscarByName(String nome) throws Exception;

    public void remover(Item item) throws Exception;

}
