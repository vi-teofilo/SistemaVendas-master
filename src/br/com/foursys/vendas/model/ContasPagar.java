/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pbido
 */
@Entity
@Table(name = "contas_pagar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContasPagar.findAll", query = "SELECT c FROM ContasPagar c"),
    @NamedQuery(name = "ContasPagar.findByIdContasPagar", query = "SELECT c FROM ContasPagar c WHERE c.idContasPagar = :idContasPagar"),
    @NamedQuery(name = "ContasPagar.findByDataVencimento", query = "SELECT c FROM ContasPagar c WHERE c.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "ContasPagar.findByDataPagamento", query = "SELECT c FROM ContasPagar c WHERE c.dataPagamento = :dataPagamento"),
    @NamedQuery(name = "ContasPagar.findByPagamento", query = "SELECT c FROM ContasPagar c WHERE c.pagamento = :pagamento"),
    @NamedQuery(name = "ContasPagar.findByVencida", query = "SELECT c FROM ContasPagar c WHERE c.vencida = :vencida")})
public class ContasPagar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contas_pagar")
    private Integer idContasPagar;
    @Basic(optional = false)
    @Column(name = "data_vencimento")
    private String dataVencimento;
    @Column(name = "data_pagamento")
    private String dataPagamento;
    @Column(name = "pagamento")
    private String pagamento;
    @Column(name = "vencida")
    private String vencida;
    @JoinColumn(name = "compra_id_compra", referencedColumnName = "id_compra")
    @ManyToOne(optional = false)
    private Compra compraIdCompra;

    public ContasPagar() {
    }

    public ContasPagar(Integer idContasPagar) {
        this.idContasPagar = idContasPagar;
    }

    public ContasPagar(Integer idContasPagar, String dataVencimento) {
        this.idContasPagar = idContasPagar;
        this.dataVencimento = dataVencimento;
    }

    public Integer getIdContasPagar() {
        return idContasPagar;
    }

    public void setIdContasPagar(Integer idContasPagar) {
        this.idContasPagar = idContasPagar;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getVencida() {
        return vencida;
    }

    public void setVencida(String vencida) {
        this.vencida = vencida;
    }

    public Compra getCompraIdCompra() {
        return compraIdCompra;
    }

    public void setCompraIdCompra(Compra compraIdCompra) {
        this.compraIdCompra = compraIdCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContasPagar != null ? idContasPagar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContasPagar)) {
            return false;
        }
        ContasPagar other = (ContasPagar) object;
        if ((this.idContasPagar == null && other.idContasPagar != null) || (this.idContasPagar != null && !this.idContasPagar.equals(other.idContasPagar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.foursys.vendas.model.ContasPagar[ idContasPagar=" + idContasPagar + " ]";
    }
    
}
