/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Item;
import com.felpz.salao.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Felps
 */
public class DaoItem extends DaoGenericImpl<Item> implements IItemDao {
    
    private EntityManager em;
    
    @Override
    public List<Item> listarAll() throws Exception {
        List<Item> lista;
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createNativeQuery("select * from Item", Item.class);
            lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JPAUtil.close();
        }
        return null;
    }
    
    @Override
    public List<Item> listarAllByName(String nome) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Item buscarByName(String nome) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void remover(Item item) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
