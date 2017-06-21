/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Usuario;
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
public class DaoUsuario implements IUsuarioDao {

    private EntityManager em;
    private List<Usuario> lista;

    @Override
    public void salvar(Usuario usuario) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
            throw new Exception("ERRO AO CADASTRAR USUARIO: " + usuario.getNome().toUpperCase());
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public Usuario buscarById(long id) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select u from Usuario u where u.id = :id");
            query.setParameter("id", id);
            return (Usuario) query.getSingleResult();
        } catch (Exception ex) {
            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_BUSCAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public Usuario buscarByLoginAndPassword(String login, String senha) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select u from Usuario u where u.login = :login and u.password = :password and status = true   ");
            query.setParameter("login", login);
            query.setParameter("password", senha);
            return (Usuario) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
//            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_BUSCAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
        return null;
    }

    @Override
    public Usuario buscarByLogin(String login) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select u from Usuario u where u.login = :login");
            query.setParameter("login", login);
            return (Usuario) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
//            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_BUSCAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
        return null;
    }

    @Override
    public List<Usuario> listarAll() throws Exception {
        lista = new ArrayList<>();
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createNativeQuery("select * from usuario_view", Usuario.class);
            lista = query.getResultList();
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
//            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_LISTAR + " LISTA DE USUARIOS INDISPONIVEL!"));
        } finally {
            JPAUtil.close();
        }
        return null;
    }

    @Override
    public void editar(Usuario usuario) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_EDITAR + " " + usuario.getNome().toUpperCase()));
        } finally {
            JPAUtil.close();
        }
    }

    /*EDITAR O STATUS*/
    @Override
    public void remover(Usuario usuario) throws Exception {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_REMOVER + " " + usuario.getNome().toUpperCase()));
        } finally {
            JPAUtil.close();
        }
    }

}
