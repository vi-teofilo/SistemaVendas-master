package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.CidadeDAO;
import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.model.Estado;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class CidadeTeste {

    public static void main(String[] temaki) throws Exception {
        new CidadeTeste().salvarCidade();
    }

    public void salvarCidade() {
        CidadeDAO dao = new CidadeDAO();
        Estado estado = new Estado();
        estado.setIdEstado(1);
        Cidade cidade = new Cidade();
        cidade.setNome("Osasco");
        cidade.setEstadoIdEstado(estado);
        dao.salvar(cidade);
        System.out.println("Cidade salva com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        CidadeDAO dao = new CidadeDAO();
        Cidade cidade = dao.buscarPorCodigo(1);
        System.out.println("Nome: " + cidade.getNome());
        System.out.println("Estado: " + cidade.getEstadoIdEstado().getNome() + " - " + cidade.getEstadoIdEstado().getUf());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        CidadeDAO dao = new CidadeDAO();
        ArrayList<Cidade> lista = dao.buscarTodos();
        for (Cidade lista1 : lista) {
            System.out.println("Nome: " + lista1.getNome());
            System.out.println("Estado: " + lista1.getEstadoIdEstado().getNome() + " - " + lista1.getEstadoIdEstado().getUf() + "\n");
        }
        System.exit(0);
    }
}
