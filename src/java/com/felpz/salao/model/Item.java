/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.model;

import javax.persistence.*;

/**
 *
 * @author Felps
 */
@Embeddable
public class Item {

    private String descricao;
    @Column(name = "valor_unt")
    private double valor;

    public Item() {

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Item{" + "descricao=" + descricao + ", valor=" + valor + '}';
    }

}
