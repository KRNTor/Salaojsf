/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.model;

import com.felpz.salao.comumenum.Funcao;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Felps
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    @Column(unique = true)
    private String login;
    private String password;
    @Enumerated
    private Funcao funcao;
    private boolean status;
    @ElementCollection(fetch = FetchType.EAGER, targetClass = Notificacao.class)
    @CollectionTable(name = "Notificacoes", joinColumns = @JoinColumn(name = "usuario_id"))
    private List<Notificacao> notificacoes;

    public Usuario() {
    }

    public Usuario(long id, String nome, String login, String password, Funcao funcao, boolean status, List<Notificacao> notificacoes) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.password = password;
        this.funcao = funcao;
        this.status = status;
        this.notificacoes = notificacoes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", login=" + login + ", password=" + password + ", funcao=" + funcao + ", status=" + status + ", notificacoes=" + notificacoes + '}';
    }

}
