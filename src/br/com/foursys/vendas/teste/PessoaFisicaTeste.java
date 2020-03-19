package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.PessoaFisicaDAO;
import br.com.foursys.vendas.model.PessoaFisica;
import br.com.foursys.vendas.model.Venda;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class PessoaFisicaTeste {

    public static void main(String[] temaki) throws Exception {
        new PessoaFisicaTeste().buscarTodos();
    }

    public void salvarPessoaFisica() {
        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = new PessoaFisica();
        Venda venda = new Venda();
        venda.setIdVenda(1);
        pessoaFisica.setNome("Pedrito");
        pessoaFisica.setRg("34.873.987.0");
        pessoaFisica.setCpf("345.876.268-87");
        pessoaFisica.setDataNascimento("04/06/200");

        dao.salvar(pessoaFisica);
        System.out.println("PessoaFisica salva com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = dao.buscarPorCodigo(5);
        System.out.println("Nome: " + pessoaFisica.getNome());
        System.out.println("RG: " + pessoaFisica.getRg());
        System.out.println("CPF: " + pessoaFisica.getCpf());
        System.out.println("Data de Nascimento: " + pessoaFisica.getDataNascimento());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        ArrayList<PessoaFisica> lista = dao.buscarTodos();
        for (PessoaFisica pessoaFisica : lista) {
            System.out.println("Nome: " + pessoaFisica.getNome());
            System.out.println("RG: " + pessoaFisica.getRg());
            System.out.println("CPF: " + pessoaFisica.getCpf());
            System.out.println("Data de Nascimento: " + pessoaFisica.getDataNascimento() + "\n");
        }
        System.exit(0);
    }
}
