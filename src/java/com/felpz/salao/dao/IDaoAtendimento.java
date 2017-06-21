/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Atendimento;
import java.util.List;
import com.felpz.salao.dao.IDaoGeneric;

/**
 *
 * @author Felps
 */
public interface IDaoAtendimento extends IDaoGeneric<Atendimento> {
    
    public List<Atendimento> buscarListaAtendimentoByClienteName(String nome) throws Exception;
    
    public List<Atendimento> listarAll() throws Exception;
    
    public void remover(Atendimento atendimento) throws Exception;
    
}
