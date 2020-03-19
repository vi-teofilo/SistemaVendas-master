package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.ContasReceberDAO;
import br.com.foursys.vendas.model.ContasReceber;
import br.com.foursys.vendas.model.Venda;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class ContasReceberTeste {

    public static void main(String[] temaki) throws Exception {
        new ContasReceberTeste().buscarTodos();
    }

    public void salvarContasReceber() {
        ContasReceberDAO dao = new ContasReceberDAO();
        ContasReceber contasReceber = new ContasReceber();
        Venda venda = new Venda();
        venda.setIdVenda(1);
        contasReceber.setVendaIdVenda(venda);
        contasReceber.setDataVencimento("15/03/2020");
        contasReceber.setPagamento("SIM");
        contasReceber.setVencida("NÃO");

        dao.salvar(contasReceber);
        System.out.println("ContasReceber salva com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        ContasReceberDAO dao = new ContasReceberDAO();
        ContasReceber contasReceber = dao.buscarPorCodigo(1);
        System.out.println("Data Vencimento: " + contasReceber.getDataVencimento());
        System.out.println("Venda: " + contasReceber.getVendaIdVenda().getIdVenda());
        System.out.println("Pagamento: " + contasReceber.getPagamento());
        System.out.println("Vencida: " + contasReceber.getVencida());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        ContasReceberDAO dao = new ContasReceberDAO();
        ArrayList<ContasReceber> lista = dao.buscarTodos();
        for (ContasReceber contasReceber : lista) {
            System.out.println("Data Vencimento: " + contasReceber.getDataVencimento());
            System.out.println("Venda: " + contasReceber.getVendaIdVenda().getIdVenda());
            System.out.println("Pagamento: " + contasReceber.getPagamento());
            System.out.println("Vencida: " + contasReceber.getVencida() + "\n");
        }
        System.exit(0);
    }
}
