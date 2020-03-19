package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.ContatoDAO;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.model.Estado;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class ContatoTeste {

    public static void main(String[] temaki) throws Exception {
        new ContatoTeste().salvarContato();
    }

    public void salvarContato() {
        ContatoDAO dao = new ContatoDAO();
        Estado estado = new Estado();
        estado.setIdEstado(1);
        Contato contato = new Contato();
        contato.setTelefone("(11)4624-7878");
        contato.setCelular("(11)99712-3827");
        contato.setEmail("fornecedor@gmail.com");
        dao.salvar(contato);
        System.out.println("Contato salvo com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        ContatoDAO dao = new ContatoDAO();
        Contato contato = dao.buscarPorCodigo(1);
        System.out.println("Telefone: " + contato.getTelefone());
        System.out.println("Celular: " + contato.getCelular());
        System.out.println("Email: " + contato.getEmail());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        ContatoDAO dao = new ContatoDAO();
        ArrayList<Contato> lista = dao.buscarTodos();
        for (Contato lista1 : lista) {
            System.out.println("Telefone: " + lista1.getTelefone());
            System.out.println("Celular: " + lista1.getCelular());
            System.out.println("Email: " + lista1.getEmail());
        }
        System.exit(0);
    }
}
