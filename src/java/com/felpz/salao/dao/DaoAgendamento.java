/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Agendamento;
import com.felpz.salao.util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Felps
 */
public class DaoAgendamento extends DaoGenericImpl<Agendamento> implements IDaoAgendamento {

    private EntityManager em;
    private List<Agendamento> lista;

    @Override
    public List<Agendamento> buscarListaAgendamentoByClienteName(String nome) throws Exception {
        try {
            this.lista = null;
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select a from Agendamento a, Pessoa c where a.cliente = c and c.nome like :nome", Agendamento.class);
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
    public List<Agendamento> listarAll() throws Exception {
        try {
            lista = new ArrayList<>();
            em = JPAUtil.getEntityManager();
            Query query = em.createNativeQuery("SELECT * FROM agendamento_view", Agendamento.class);
            lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JPAUtil.close();
        }
        return null;
    }


    /*EDITAR STATUS*/
    @Override
    public void remover(Agendamento agendamento) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(agendamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JPAUtil.close();
        }
    }

}
