/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.dao;

import com.felpz.salao.model.Agendamento;
import java.util.List;

/**
 *
 * @author Felps
 */
public interface IDaoAgendamento extends IDaoGeneric<Agendamento> {

    public List<Agendamento> buscarListaAgendamentoByClienteName(String nome) throws Exception;

    public List<Agendamento> listarAll() throws Exception;

    public void remover(Agendamento agendamento) throws Exception;

}
