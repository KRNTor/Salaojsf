/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Pessoa;
import com.felpz.salao.util.JPAUtil;
import com.felpz.salao.util.PropertiesUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Felps
 */
public class DaoPessoa extends DaoGenericImpl<Pessoa> implements IPessoaDao {

    private EntityManager em;
    private List<Pessoa> lista = new ArrayList<>();

    @Override
    public Pessoa buscarByName(String nome) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("SELECT p FROM Pessoa p WHERE p.nome = :nome");
            query.setParameter("nome", nome);
            return (Pessoa) query.getSingleResult();
        } catch (Exception ex) {
            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_BUSCAR + " USUARIO NÃO ENCONTRADO!"));
        }
    }

    @Override
    public void remover(Pessoa pessoa) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public List<Pessoa> listarAll() throws Exception {
        try {
            this.lista = new ArrayList<>();
            em = JPAUtil.getEntityManager();
            Query query = em.createNativeQuery("select * from pessoa_view", Pessoa.class);
            lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_LISTAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public List<Pessoa> listarAllCliente() throws Exception {
        try {
            this.lista = new ArrayList<>();
            em = JPAUtil.getEntityManager();
            Query query = em.createNativeQuery("select p.* from Pessoa p where p.tipo = 1", Pessoa.class);
            lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
//            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_LISTAR + " USUARIO NÃO ENCONTRADO!"));
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JPAUtil.close();
        }
        return null;
    }

    @Override
    public List<Pessoa> listarFuncionario() throws Exception {
        try {
            this.lista = new ArrayList<>();
            em = JPAUtil.getEntityManager();
            Query query = em.createNativeQuery("select * from funcionario_view", Pessoa.class);
            lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_LISTAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public List<Pessoa> buscarListaClienteByName(String nome) throws Exception {
        try {
            this.lista = null;
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select c from Pessoa c where c.status = true and c.nome like :nome", Pessoa.class);
            query.setParameter("nome", "%" + nome + "%");
            lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_LISTAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public List<Pessoa> buscarListaFuncionarioByName(String nome) throws Exception {
        try {
            this.lista = null;
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select c from Pessoa c where c.status = true and c.nome like :nome", Pessoa.class);
            query.setParameter("nome", "%" + nome + "%");
            lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_LISTAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
    }

}
