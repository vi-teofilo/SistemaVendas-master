package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.ContasPagarDAO;
import br.com.foursys.vendas.model.Compra;
import br.com.foursys.vendas.model.ContasPagar;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class ContasPagarTeste {

    public static void main(String[] temaki) throws Exception {
        new ContasPagarTeste().buscarTodos();
    }

    public void salvarContasPagar() {
        ContasPagarDAO dao = new ContasPagarDAO();
        ContasPagar contasPagar = new ContasPagar();
        Compra compra = new Compra();
        compra.setIdCompra(1);
        contasPagar.setCompraIdCompra(compra);
        contasPagar.setDataVencimento("15/03/2020");
        contasPagar.setDataPagamento("11/03/2020");
        contasPagar.setPagamento("SIM");
        contasPagar.setVencida("NÃO");
        dao.salvar(contasPagar);
        System.out.println("ContasPagar salva com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        ContasPagarDAO dao = new ContasPagarDAO();
        ContasPagar contasPagar = dao.buscarPorCodigo(2);
        System.out.println("Data Vencimento: " + contasPagar.getDataVencimento());
        System.out.println("Data Pagamento: " + contasPagar.getDataPagamento());
        System.out.println("Pagamento: " + contasPagar.getPagamento());
        System.out.println("Vencida: " + contasPagar.getVencida());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        ContasPagarDAO dao = new ContasPagarDAO();
        ArrayList<ContasPagar> lista = dao.buscarTodos();
        for (ContasPagar contasPagar : lista) {
            System.out.println("Data Vencimento: " + contasPagar.getDataVencimento());
            System.out.println("Data Pagamento: " + contasPagar.getDataPagamento());
            System.out.println("Pagamento: " + contasPagar.getPagamento());
            System.out.println("Vencida: " + contasPagar.getVencida() + "\n");
        }
        System.exit(0);
    }
}
