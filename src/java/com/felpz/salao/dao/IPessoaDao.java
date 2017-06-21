/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Pessoa;
import java.util.List;

/**
 *
 * @author Felps
 */
public interface IPessoaDao extends IDaoGeneric<Pessoa> {
    
    public Pessoa buscarByName(String nome) throws Exception;
    
    public List<Pessoa> buscarListaClienteByName(String nome) throws Exception;
    
    public List<Pessoa> buscarListaFuncionarioByName(String nome) throws Exception;
    
    public List<Pessoa> listarAll() throws Exception;
    
    public List<Pessoa> listarAllCliente() throws Exception;
    
    public List<Pessoa> listarFuncionario() throws Exception;
    
    public void remover(Pessoa pessoa) throws Exception;
    
}
