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
public enum Funcao {
    ADM("Administrador"), FUNCIONARIO("Funcionário");

    private String funcao;

    private Funcao(String funcao) {
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public String toString() {
        return this.funcao;
    }

}
