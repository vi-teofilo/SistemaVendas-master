package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.ItemVendaDAO;
import br.com.foursys.vendas.model.ItemVenda;
import br.com.foursys.vendas.model.Produto;
import br.com.foursys.vendas.model.Venda;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class ItemVendaTeste {

    public static void main(String[] temaki) throws Exception {
        new ItemVendaTeste().buscarTodos();
    }

    public void salvarItemVenda() {
        ItemVendaDAO dao = new ItemVendaDAO();
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setQuantidadeProduto(135);
        itemVenda.setDescontoProduto(50.00);
        itemVenda.setValorTotal(100.0);
        Venda venda = new Venda();
        venda.setIdVenda(1);
        itemVenda.setVendaIdVenda(venda);
        Produto produto = new Produto();
        produto.setIdProduto(1);
        itemVenda.setProdutoIdProduto(produto);
        dao.salvar(itemVenda);
        System.out.println("ItemVenda salva com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        ItemVendaDAO dao = new ItemVendaDAO();
        ItemVenda itemVenda = dao.buscarPorCodigo(1);
        System.out.println("Quantidade de Produtos: " + itemVenda.getQuantidadeProduto());
        System.out.println("Valor desconto: " + itemVenda.getDescontoProduto());
        System.out.println("Valor total: " + itemVenda.getValorTotal());
        System.out.println("Venda: " + itemVenda.getVendaIdVenda().getIdVenda());
        System.out.println("Produto: " + itemVenda.getProdutoIdProduto().getDescricao());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        ItemVendaDAO dao = new ItemVendaDAO();
        ArrayList<ItemVenda> lista = dao.buscarTodos();
        for (ItemVenda itemVenda : lista) {
            System.out.println("Quantidade de Produtos: " + itemVenda.getQuantidadeProduto());
            System.out.println("Valor desconto: " + itemVenda.getDescontoProduto());
            System.out.println("Valor total: " + itemVenda.getValorTotal());
            System.out.println("Venda: " + itemVenda.getProdutoIdProduto().getDescricao());
        }
        System.exit(0);
    }
}
