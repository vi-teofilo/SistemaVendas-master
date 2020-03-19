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
@Table(name = "item_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemVenda.findAll", query = "SELECT i FROM ItemVenda i"),
    @NamedQuery(name = "ItemVenda.findByIdItemVenda", query = "SELECT i FROM ItemVenda i WHERE i.idItemVenda = :idItemVenda"),
    @NamedQuery(name = "ItemVenda.findByQuantidadeProduto", query = "SELECT i FROM ItemVenda i WHERE i.quantidadeProduto = :quantidadeProduto"),
    @NamedQuery(name = "ItemVenda.findByDescontoProduto", query = "SELECT i FROM ItemVenda i WHERE i.descontoProduto = :descontoProduto"),
    @NamedQuery(name = "ItemVenda.findByValorTotal", query = "SELECT i FROM ItemVenda i WHERE i.valorTotal = :valorTotal")})
public class ItemVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_venda")
    private Integer idItemVenda;
    @Basic(optional = false)
    @Column(name = "quantidade_produto")
    private int quantidadeProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "desconto_produto")
    private Double descontoProduto;
    @Basic(optional = false)
    @Column(name = "valor_total")
    private double valorTotal;
    @JoinColumn(name = "produto_id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto produtoIdProduto;
    @JoinColumn(name = "venda_id_venda", referencedColumnName = "id_venda")
    @ManyToOne(optional = false)
    private Venda vendaIdVenda;

    public ItemVenda() {
    }

    public ItemVenda(Integer idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public ItemVenda(Integer idItemVenda, int quantidadeProduto, double valorTotal) {
        this.idItemVenda = idItemVenda;
        this.quantidadeProduto = quantidadeProduto;
        this.valorTotal = valorTotal;
    }

    public Integer getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(Integer idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Double getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(Double descontoProduto) {
        this.descontoProduto = descontoProduto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProdutoIdProduto() {
        return produtoIdProduto;
    }

    public void setProdutoIdProduto(Produto produtoIdProduto) {
        this.produtoIdProduto = produtoIdProduto;
    }

    public Venda getVendaIdVenda() {
        return vendaIdVenda;
    }

    public void setVendaIdVenda(Venda vendaIdVenda) {
        this.vendaIdVenda = vendaIdVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemVenda != null ? idItemVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVenda)) {
            return false;
        }
        ItemVenda other = (ItemVenda) object;
        if ((this.idItemVenda == null && other.idItemVenda != null) || (this.idItemVenda != null && !this.idItemVenda.equals(other.idItemVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.foursys.vendas.model.ItemVenda[ idItemVenda=" + idItemVenda + " ]";
    }
    
}
