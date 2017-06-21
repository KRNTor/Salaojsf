/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Felps
 */
@Entity
public class Agendamento implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dtAtualAgendamento;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFuturaAgendamento;
    @OneToOne
    private Pessoa cliente;
    private String descricao;
    private boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDtAtualAgendamento() {
        return dtAtualAgendamento;
    }

    public void setDtAtualAgendamento(Date dtAtualAgendamento) {
        this.dtAtualAgendamento = dtAtualAgendamento;
    }

    public Date getDtFuturaAgendamento() {
        return dtFuturaAgendamento;
    }

    public void setDtFuturaAgendamento(Date dtFuturaAgendamento) {
        this.dtFuturaAgendamento = dtFuturaAgendamento;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "id=" + id + ", dtAtualAgendamento=" + dtAtualAgendamento + ", dtFuturaAgendamento=" + dtFuturaAgendamento + ", cliente=" + cliente + ", descricao=" + descricao + ", status=" + status + '}';
    }

}
