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
@Table(name = "log_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogUsuario.findAll", query = "SELECT l FROM LogUsuario l"),
    @NamedQuery(name = "LogUsuario.findByIdLogUsuario", query = "SELECT l FROM LogUsuario l WHERE l.idLogUsuario = :idLogUsuario"),
    @NamedQuery(name = "LogUsuario.findByTimestamp", query = "SELECT l FROM LogUsuario l WHERE l.timestamp = :timestamp"),
    @NamedQuery(name = "LogUsuario.findByOperacao", query = "SELECT l FROM LogUsuario l WHERE l.operacao = :operacao"),
    @NamedQuery(name = "LogUsuario.findByTabela", query = "SELECT l FROM LogUsuario l WHERE l.tabela = :tabela")})
public class LogUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log_usuario")
    private Integer idLogUsuario;
    @Basic(optional = false)
    @Column(name = "timestamp")
    private String timestamp;
    @Basic(optional = false)
    @Column(name = "operacao")
    private String operacao;
    @Column(name = "tabela")
    private String tabela;
    @JoinColumn(name = "funcionario_id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario funcionarioIdFuncionario;

    public LogUsuario() {
    }

    public LogUsuario(Integer idLogUsuario) {
        this.idLogUsuario = idLogUsuario;
    }

    public LogUsuario(Integer idLogUsuario, String timestamp, String operacao) {
        this.idLogUsuario = idLogUsuario;
        this.timestamp = timestamp;
        this.operacao = operacao;
    }

    public Integer getIdLogUsuario() {
        return idLogUsuario;
    }

    public void setIdLogUsuario(Integer idLogUsuario) {
        this.idLogUsuario = idLogUsuario;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public Funcionario getFuncionarioIdFuncionario() {
        return funcionarioIdFuncionario;
    }

    public void setFuncionarioIdFuncionario(Funcionario funcionarioIdFuncionario) {
        this.funcionarioIdFuncionario = funcionarioIdFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogUsuario != null ? idLogUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogUsuario)) {
            return false;
        }
        LogUsuario other = (LogUsuario) object;
        if ((this.idLogUsuario == null && other.idLogUsuario != null) || (this.idLogUsuario != null && !this.idLogUsuario.equals(other.idLogUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.foursys.vendas.model.LogUsuario[ idLogUsuario=" + idLogUsuario + " ]";
    }
    
}
