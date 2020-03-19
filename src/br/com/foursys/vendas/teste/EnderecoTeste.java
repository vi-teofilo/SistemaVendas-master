/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.EnderecoDAO;
import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.model.Endereco;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class EnderecoTeste {

    public static void main(String[] flowers) throws Exception {
        new EnderecoTeste().salvarEndereco();
    }

    public void salvarEndereco() {
        EnderecoDAO dao = new EnderecoDAO();
        Endereco endereco = new Endereco();
        Cidade cidade = new Cidade();
        cidade.setIdCidade(5);
        endereco.setLogradouro("Rua Augusta");
        endereco.setNumero(87);
        endereco.setBairro("Paulista");
        endereco.setComplemento("9º Andar");
        endereco.setCep("12753-988");
        endereco.setCidadeIdCidade(cidade);
        dao.salvar(endereco);
        System.out.println("Endereço salvo com sucesso.");
        System.exit(0);
    }

    public void buscarPorCodigo() throws Exception {
        EnderecoDAO dao = new EnderecoDAO();
        Endereco endereco = dao.buscarPorCodigo(1);
        System.out.println("Logradouro: " + endereco.getLogradouro() + " Número: " + endereco.getNumero());
        System.out.println("Bairro: " + endereco.getBairro() + " Complemento: " + endereco.getComplemento());
        System.out.println("Cidade: " + endereco.getCidadeIdCidade().getNome()
                + " Estado: " + endereco.getCidadeIdCidade().getEstadoIdEstado().getNome()
                + " - " + endereco.getCidadeIdCidade().getEstadoIdEstado().getUf() + "\n");
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        EnderecoDAO dao = new EnderecoDAO();
        ArrayList<Endereco> lista = dao.buscarTodos();
        for (Endereco lista1 : lista) {
            System.out.println("Logradouro: " + lista1.getLogradouro() + " Número: " + lista1.getNumero());
            System.out.println("Bairro: " + lista1.getBairro() + " Complemento: " + lista1.getComplemento());
            System.out.println("Cidade: " + lista1.getCidadeIdCidade().getNome()
                    + " Estado: " + lista1.getCidadeIdCidade().getEstadoIdEstado().getNome()
                    + " - " + lista1.getCidadeIdCidade().getEstadoIdEstado().getUf() + "\n");
        }
        System.exit(0);
    }
}
