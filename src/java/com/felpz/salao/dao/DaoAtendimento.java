/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Atendimento;
import com.felpz.salao.util.JPAUtil;
import com.felpz.salao.util.PropertiesUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Felps
 */
public class DaoAtendimento extends DaoGenericImpl<Atendimento> implements IDaoAtendimento {

    private EntityManager em;
    private List<Atendimento> lista;

    @Override
    public List<Atendimento> buscarListaAtendimentoByClienteName(String nome) throws Exception {
        try {
            this.lista = null;
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select a from Atendimento a, Pessoa c where a.cliente = c and c.nome like :nome", Atendimento.class);
            query.setParameter("nome", "%" + nome + "%");
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
    public List<Atendimento> listarAll() throws Exception {
        lista = new ArrayList<>();
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createNativeQuery("select * from atendimento_view", Atendimento.class);
            lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_LISTAR));
        }
    }

    @Override
    public void remover(Atendimento atendimento) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(atendimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            JPAUtil.close();
        }
    }

}
