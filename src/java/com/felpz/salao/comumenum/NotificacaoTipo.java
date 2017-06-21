/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.comumenum;

/**
 *
 * @author felpz
 */
public enum NotificacaoTipo {
    CADASTRO_USUARIO("Novo Cadastro de Usuario"), AGENDAMENTO_DO_DIA("Agendamento do dia"), USUARIO_CADASTRADO("Usuario cadastrado com sucesso!");

    String tipo;

    private NotificacaoTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String toString() {
        return this.tipo;
    }
}
