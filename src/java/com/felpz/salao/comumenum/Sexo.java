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
public enum Sexo {
    MASCULINO("Masculino"), 
    FEMININO("Feminino");

    private String sexo;

    private Sexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Sexo{ " + sexo + " }";
    }

}
