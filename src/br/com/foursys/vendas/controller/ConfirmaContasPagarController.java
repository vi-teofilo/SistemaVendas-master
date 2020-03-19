package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ContasPagarDAO;
import br.com.foursys.vendas.model.Compra;
import br.com.foursys.vendas.model.ContasPagar;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.view.ConfirmarContasPagar;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author pbido
 */
public class ConfirmaContasPagarController {

    private Compra compra = new Compra();
    private ConfirmarContasPagar viewContasPagar;

    public ConfirmaContasPagarController(ConfirmarContasPagar viewContasPagar) {
        this.viewContasPagar = viewContasPagar;
    }

    public void acaoBotaoConfirmar() {
        int x = JOptionPane.showConfirmDialog(null, Mensagem.confirmaCompra, Mensagem.atencao,
                JOptionPane.YES_NO_OPTION);
        if ((x == JOptionPane.YES_OPTION)) {
            salvarContaPagar();
        }
    }

    private void salvarContaPagar() {
        ContasPagarDAO contasPagarDAO = new ContasPagarDAO();
        ContasPagar conta = new ContasPagar();
        conta.setCompraIdCompra(compra);
        conta.setDataPagamento(LocalDate.now() + "");
        conta.setDataVencimento(this.viewContasPagar.getJtfDataVencimento().getText());
        conta.setPagamento(this.viewContasPagar.getJcbPagamento().getSelectedItem().toString());
        conta.setVencida(this.viewContasPagar.getJcbVencimento().getSelectedItem().toString());
        try {
            contasPagarDAO.salvar(conta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Mensagem.erroSalvarContaPagar);
        }
        JOptionPane.showMessageDialog(null, Mensagem.sucessoSalvarContaPagar);
        JOptionPane.showMessageDialog(null, Mensagem.sucessoSalvarCompra);
        this.viewContasPagar.dispose();
    }

    public void carregaDadosCompra(Compra compra) {
        this.compra = compra;
        this.viewContasPagar.getJlbValorCompra().setText(compra.getValorTotal());
        this.viewContasPagar.getJlbFormaPagamento().setText(compra.getFormaPagamento());
        this.viewContasPagar.getJlbFuncionario().setText(compra.getFuncionarioIdFuncionario().getPessoaFisicaIdPessoaFisica().getNome());
        this.viewContasPagar.getJlbFornecedor().setText(compra.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
    }

    public void carregaContaPagar() {
        this.viewContasPagar.getJtfDataCompra().setText(LocalDate.now() + "");
        this.viewContasPagar.getJtfDataCompra().setEnabled(false);
        this.viewContasPagar.getJcbPagamento().setSelectedIndex(2);
        this.viewContasPagar.getJcbPagamento().setEnabled(false);
        this.viewContasPagar.getJcbVencimento().setSelectedIndex(2);
        this.viewContasPagar.getJcbVencimento().setEnabled(false);
    }

}
