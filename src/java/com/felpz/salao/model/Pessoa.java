/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.model;

import com.felpz.salao.comumenum.Tipo;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author Felps
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    private String telefone;
    private String celular;
    private boolean status;
    @Enumerated
    private Tipo tipo;

    public Pessoa() {
    }

    public Pessoa(long id, String nome, Date dtNascimento, Endereco endereco, String telefone, String celular, boolean status, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.celular = celular;
        this.status = status;
        this.tipo = tipo;
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

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", dtNascimento=" + dtNascimento + ", endereco=" + endereco + ", telefone=" + telefone + ", celular=" + celular + ", status=" + status + ", tipo=" + tipo + '}';
    }

}
