/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felpz.salao.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Felps
 */
@Entity
public class Gasto {

    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dtCompra;
    @ElementCollection
    @CollectionTable(name="Item", joinColumns = @JoinColumn(name="gasto_id"))
    private List<Item> item;
    private double valorGeral;
    private boolean status;

    public Gasto() {

    }

    public Gasto(long id, Date dtCompra, List<Item> item, double valor, boolean status) {
        this.id = id;
        this.dtCompra = dtCompra;
        this.item = item;
        this.valorGeral = valor;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(Date dtCompra) {
        this.dtCompra = dtCompra;
    }

    public List<Item> getItens() {
        return item;
    }

    public void setItens(List<Item> item) {
        this.item = item;
    }

    public double getValor() {
        return valorGeral;
    }

    public void setValor(double valor) {
        this.valorGeral = valor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", dtCompra=" + dtCompra + ", Itens=" + item + ", valor=" + valorGeral + ", status=" + status + '}';
    }

}
