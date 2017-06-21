/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Usuario;
import java.util.List;

/**
 *
 * @author Felps
 */
public interface IUsuarioDao {

    public void salvar(Usuario usuario) throws Exception;

    public Usuario buscarById(long id) throws Exception;

    public Usuario buscarByLoginAndPassword(String login, String senha) throws Exception;

    public Usuario buscarByLogin(String login) throws Exception;

    public List<Usuario> listarAll() throws Exception;

    public void editar(Usuario usuario) throws Exception;

    public void remover(Usuario usuario) throws Exception;
}
