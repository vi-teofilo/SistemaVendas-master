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
@Table(name = "item_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemCompra.findAll", query = "SELECT i FROM ItemCompra i"),
    @NamedQuery(name = "ItemCompra.findByIdItemCompra", query = "SELECT i FROM ItemCompra i WHERE i.idItemCompra = :idItemCompra"),
    @NamedQuery(name = "ItemCompra.findByQuantidadeProduto", query = "SELECT i FROM ItemCompra i WHERE i.quantidadeProduto = :quantidadeProduto"),
    @NamedQuery(name = "ItemCompra.findByValorTotal", query = "SELECT i FROM ItemCompra i WHERE i.valorTotal = :valorTotal")})
public class ItemCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_compra")
    private Integer idItemCompra;
    @Basic(optional = false)
    @Column(name = "quantidade_produto")
    private String quantidadeProduto;
    @Basic(optional = false)
    @Column(name = "valor_total")
    private double valorTotal;
    @JoinColumn(name = "compra_id_compra", referencedColumnName = "id_compra")
    @ManyToOne(optional = false)
    private Compra compraIdCompra;
    @JoinColumn(name = "produto_id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto produtoIdProduto;

    public ItemCompra() {
    }

    public ItemCompra(Integer idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    public ItemCompra(Integer idItemCompra, String quantidadeProduto, double valorTotal) {
        this.idItemCompra = idItemCompra;
        this.quantidadeProduto = quantidadeProduto;
        this.valorTotal = valorTotal;
    }

    public Integer getIdItemCompra() {
        return idItemCompra;
    }

    public void setIdItemCompra(Integer idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    public String getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(String quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Compra getCompraIdCompra() {
        return compraIdCompra;
    }

    public void setCompraIdCompra(Compra compraIdCompra) {
        this.compraIdCompra = compraIdCompra;
    }

    public Produto getProdutoIdProduto() {
        return produtoIdProduto;
    }

    public void setProdutoIdProduto(Produto produtoIdProduto) {
        this.produtoIdProduto = produtoIdProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemCompra != null ? idItemCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCompra)) {
            return false;
        }
        ItemCompra other = (ItemCompra) object;
        if ((this.idItemCompra == null && other.idItemCompra != null) || (this.idItemCompra != null && !this.idItemCompra.equals(other.idItemCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.foursys.vendas.model.ItemCompra[ idItemCompra=" + idItemCompra + " ]";
    }
    
}
