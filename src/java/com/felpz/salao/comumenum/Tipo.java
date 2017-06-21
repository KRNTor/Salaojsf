/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.comumenum;

/**
 *
 * @author Felps
 */
public enum Tipo {
    FUNCIONARIO("Funcionário"), CLIENTE("Cliente");

    private String tipo;

    private Tipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tipo{" + "tipo=" + tipo + '}';
    }
}
