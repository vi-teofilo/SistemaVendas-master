package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.EstoqueDAO;
import br.com.foursys.vendas.model.Estoque;
import br.com.foursys.vendas.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class EstoqueTeste {

    public static void main(String[] temaki) throws Exception {
        new EstoqueTeste().buscarTodos();
    }

    public void salvarEstoque() {
        EstoqueDAO dao = new EstoqueDAO();
        Estoque estoque = new Estoque();
        Produto produto = new Produto();
        produto.setIdProduto(1);
        estoque.setQuantidadeEstoque(135);
        estoque.setQuantidadeMinima(70);
        estoque.setProdutoIdProduto(produto);
        dao.salvar(estoque);
        System.out.println("Estoque salva com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        EstoqueDAO dao = new EstoqueDAO();
        Estoque estoque = dao.buscarPorCodigo(2);
        System.out.println("Qtde: " + estoque.getQuantidadeEstoque());
        System.out.println("Qtde minima: " + estoque.getQuantidadeMinima());
        System.out.println("Produto: " + estoque.getProdutoIdProduto().getDescricao());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        EstoqueDAO dao = new EstoqueDAO();
        ArrayList<Estoque> lista = dao.buscarTodos();
        for (Estoque estoque : lista) {
            System.out.println("Qtde: " + estoque.getQuantidadeEstoque());
            System.out.println("Qtde minima: " + estoque.getQuantidadeMinima());
            System.out.println("Produto: " + estoque.getProdutoIdProduto().getDescricao());
        }
        System.exit(0);
    }
}
