package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ContasReceberDAO;
import br.com.foursys.vendas.model.Compra;
import br.com.foursys.vendas.model.ContasReceber;
import br.com.foursys.vendas.model.Venda;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.view.ConfirmarContasReceber;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author pbido
 */
public class ConfirmaContasReceberController {

    private Venda venda = new Venda();
    private ConfirmarContasReceber viewContasReceber;

    public ConfirmaContasReceberController(ConfirmarContasReceber viewContasReceber) {
        this.viewContasReceber = viewContasReceber;
    }

    public void acaoBotaoConfirmar() {
        int x = JOptionPane.showConfirmDialog(null, Mensagem.confirmaVenda, Mensagem.atencao,
                JOptionPane.YES_NO_OPTION);
        if ((x == JOptionPane.YES_OPTION)) {
            salvarContaReceber();
        }
    }

    private void salvarContaReceber() {
        ContasReceberDAO contasReceberDAO = new ContasReceberDAO();
        ContasReceber conta = new ContasReceber();
        conta.setVendaIdVenda(venda);
        conta.setDataPagamento(LocalDate.now() + "");
        conta.setDataVencimento(this.viewContasReceber.getJtfDataVencimento().getText());
        conta.setPagamento(this.viewContasReceber.getJcbPagamento().getSelectedItem().toString());
        conta.setVencida(this.viewContasReceber.getJcbVencimento().getSelectedItem().toString());
        try {
            contasReceberDAO.salvar(conta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Mensagem.erroSalvarContaReceber);
        }
        JOptionPane.showMessageDialog(null, Mensagem.sucessoSalvarContaPagar);
        JOptionPane.showMessageDialog(null, Mensagem.sucessoSalvarVenda);
        this.viewContasReceber.dispose();
    }

    public void carregaDadosVenda(Venda venda) {
        this.venda = venda;
        this.viewContasReceber.getJlbValorCompra().setText(venda.getValorTotal()+"");
        this.viewContasReceber.getJlbFormaPagamento().setText(venda.getFormaPagamento());
        this.viewContasReceber.getJlbFuncionario().setText(venda.getFuncionarioIdFuncionario().getPessoaFisicaIdPessoaFisica().getNome());
        this.viewContasReceber.getJlbCliente().setText(venda.getClienteIdCliente().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        this.viewContasReceber.getJlbCliente().setText(venda.getClienteIdCliente().getPessoaFisicaIdPessoaFisica().getNome());
        
    }

    public void carregaContaReceber() {
        this.viewContasReceber.getJtfDataLancamento().setText(LocalDate.now() + "");
        this.viewContasReceber.getJtfDataLancamento().setEnabled(false);
        this.viewContasReceber.getJcbPagamento().setSelectedIndex(2);
        this.viewContasReceber.getJcbPagamento().setEnabled(false);
        this.viewContasReceber.getJcbVencimento().setSelectedIndex(2);
        this.viewContasReceber.getJcbVencimento().setEnabled(false);
    }

}
