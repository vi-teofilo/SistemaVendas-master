/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pbido
 */
@Entity
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByIdVenda", query = "SELECT v FROM Venda v WHERE v.idVenda = :idVenda"),
    @NamedQuery(name = "Venda.findByDataVenda", query = "SELECT v FROM Venda v WHERE v.dataVenda = :dataVenda"),
    @NamedQuery(name = "Venda.findByValorTotal", query = "SELECT v FROM Venda v WHERE v.valorTotal = :valorTotal"),
    @NamedQuery(name = "Venda.findByFormaPagamento", query = "SELECT v FROM Venda v WHERE v.formaPagamento = :formaPagamento")})
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venda")
    private Integer idVenda;
    @Basic(optional = false)
    @Column(name = "data_venda")
    private String dataVenda;
    @Basic(optional = false)
    @Column(name = "valor_total")
    private double valorTotal;
    @Basic(optional = false)
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendaIdVenda")
    private List<ContasReceber> contasReceberList;
    @JoinColumn(name = "cliente_id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;
    @JoinColumn(name = "funcionario_id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario funcionarioIdFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendaIdVenda")
    private List<ItemVenda> itemVendaList;

    public Venda() {
    }

    public Venda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Venda(Integer idVenda, String dataVenda, double valorTotal, String formaPagamento) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @XmlTransient
    public List<ContasReceber> getContasReceberList() {
        return contasReceberList;
    }

    public void setContasReceberList(List<ContasReceber> contasReceberList) {
        this.contasReceberList = contasReceberList;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public Funcionario getFuncionarioIdFuncionario() {
        return funcionarioIdFuncionario;
    }

    public void setFuncionarioIdFuncionario(Funcionario funcionarioIdFuncionario) {
        this.funcionarioIdFuncionario = funcionarioIdFuncionario;
    }

    @XmlTransient
    public List<ItemVenda> getItemVendaList() {
        return itemVendaList;
    }

    public void setItemVendaList(List<ItemVenda> itemVendaList) {
        this.itemVendaList = itemVendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idVenda == null && other.idVenda != null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.foursys.vendas.model.Venda[ idVenda=" + idVenda + " ]";
    }
    
}
