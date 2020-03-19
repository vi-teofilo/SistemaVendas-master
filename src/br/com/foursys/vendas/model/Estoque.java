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
@Table(name = "estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e"),
    @NamedQuery(name = "Estoque.findByIdEstoque", query = "SELECT e FROM Estoque e WHERE e.idEstoque = :idEstoque"),
    @NamedQuery(name = "Estoque.findByQuantidadeEstoque", query = "SELECT e FROM Estoque e WHERE e.quantidadeEstoque = :quantidadeEstoque"),
    @NamedQuery(name = "Estoque.findByQuantidadeMinima", query = "SELECT e FROM Estoque e WHERE e.quantidadeMinima = :quantidadeMinima")})
public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estoque")
    private Integer idEstoque;
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;
    @Column(name = "quantidade_minima")
    private Integer quantidadeMinima;
    @JoinColumn(name = "produto_id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto produtoIdProduto;

    public Estoque() {
    }

    public Estoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
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
        hash += (idEstoque != null ? idEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.idEstoque == null && other.idEstoque != null) || (this.idEstoque != null && !this.idEstoque.equals(other.idEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.foursys.vendas.model.Estoque[ idEstoque=" + idEstoque + " ]";
    }
    
}
