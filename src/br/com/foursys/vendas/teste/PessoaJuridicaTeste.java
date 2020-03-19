package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.PessoaJuridicaDAO;
import br.com.foursys.vendas.model.PessoaJuridica;
import br.com.foursys.vendas.model.Venda;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class PessoaJuridicaTeste {

    public static void main(String[] temaki) throws Exception {
        new PessoaJuridicaTeste().buscarTodos();
    }

    public void salvarPessoaJuridica() {
        PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        Venda venda = new Venda();
        venda.setIdVenda(1);
        pessoaJuridica.setRazaoSocial("Pedrito");
        pessoaJuridica.setCnpj("12.345.678/0001-23");
        pessoaJuridica.setInscricaoEstadual("123.456.234.654");
        pessoaJuridica.setDataFundacao("04/06/2000");

        dao.salvar(pessoaJuridica);
        System.out.println("PessoaJuridica salva com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
        PessoaJuridica pessoaJuridica = dao.buscarPorCodigo(1);
        System.out.println("Razao Social: " + pessoaJuridica.getRazaoSocial());
        System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
        System.out.println("IE: " + pessoaJuridica.getInscricaoEstadual());
        System.out.println("Data de Fundação: " + pessoaJuridica.getDataFundacao());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
        ArrayList<PessoaJuridica> lista = dao.buscarTodos();
        for (PessoaJuridica pessoaJuridica : lista) {
            System.out.println("Razao Social: " + pessoaJuridica.getRazaoSocial());
            System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
            System.out.println("IE: " + pessoaJuridica.getInscricaoEstadual());
            System.out.println("Data de Fundação: " + pessoaJuridica.getDataFundacao());
        }
        System.exit(0);
    }
}
