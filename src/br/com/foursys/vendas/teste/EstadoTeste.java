package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.EstadoDAO;
import br.com.foursys.vendas.model.Estado;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class EstadoTeste {

    public static void main(String[] temaki) throws Exception {
        new EstadoTeste().salvarEstado();
    }

    public void salvarEstado() {
        EstadoDAO dao = new EstadoDAO();
        Estado estado = new Estado();
        estado.setNome("São Paulo");
        estado.setUf("SP");
        dao.salvar(estado);
        System.out.println("Estado salvo com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        EstadoDAO dao = new EstadoDAO();
        Estado estado = dao.buscarPorCodigo(1);
        System.out.println("Nome: " + estado.getNome());
        System.out.println("UF: " + estado.getUf());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        EstadoDAO dao = new EstadoDAO();
        ArrayList<Estado> lista = dao.buscarTodos();
        for (Estado lista1 : lista) {
            System.out.println("Nome: " + lista1.getNome());
            System.out.println("UF: " + lista1.getUf());
        }
        System.exit(0);
    }
}
