/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Felps
 */
@Entity
public class Atendimento {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Pessoa cliente;
    private double valor;
    private String descrisao;
    @Temporal(TemporalType.DATE)
    private Date dtAtendimento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescrisao() {
        return descrisao;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }

    public Date getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento(Date dtAtendimento) {
        this.dtAtendimento = dtAtendimento;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", cliente=" + cliente + ", valor=" + valor + ", descrisao=" + descrisao + ", dtAtendimento=" + dtAtendimento + '}';
    }

}
