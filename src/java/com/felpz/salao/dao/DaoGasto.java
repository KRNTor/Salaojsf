/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Gasto;
import com.felpz.salao.util.JPAUtil;
import com.felpz.salao.util.PropertiesUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Felps
 */
public class DaoGasto extends DaoGenericImpl<Gasto> implements IDaoGasto {

    private EntityManager em;
    private List<Gasto> lista;

    @Override
    public void remover(Gasto compra) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(compra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_CADASTRAR + " COMPRA!"));
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public List<Gasto> listarAll() throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createNativeQuery("select * from compra_view", Gasto.class);
            lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
//            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_CADASTRAR + " COMPRA!"));
            ex.printStackTrace();
        } finally {
            JPAUtil.close();
        }
        return null;
    }

}
