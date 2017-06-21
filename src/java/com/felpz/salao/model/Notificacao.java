/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.model;

import com.felpz.salao.comumenum.NotificacaoTipo;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

/**
 *
 * @author felpz
 */
@Embeddable
public class Notificacao {

    @Enumerated
    private NotificacaoTipo tipo;
    private String descricao;
    private boolean status;

    public Notificacao() {

    }

    public Notificacao(NotificacaoTipo tipo, String descricao, boolean status) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.status = status;
    }

    public NotificacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(NotificacaoTipo tipo) {
        this.tipo = tipo;
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
        return "Notificacao{" + "tipo=" + tipo + ", descricao=" + descricao + ", status=" + status + '}';
    }

}
