package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ContasReceberDAO;
import br.com.foursys.vendas.dao.ItemVendaDAO;
import br.com.foursys.vendas.dao.VendaDAO;
import br.com.foursys.vendas.model.Cliente;
import br.com.foursys.vendas.model.ContasReceber;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.ItemVenda;
import br.com.foursys.vendas.model.Produto;
import br.com.foursys.vendas.model.Venda;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.ConfirmarContasReceber;
import br.com.foursys.vendas.view.VendasPrincipal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fcorrea
 *
 */
public class VendasController {

    private VendasPrincipal viewVendas;
    private Venda venda = new Venda();
    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;
    private List<Produto> listaProdutos;
    private List<ItemVenda> listaItemVenda = new ArrayList<>();
    private boolean alterar;

    public VendasController() {

    }

    public VendasController(VendasPrincipal viewVendas) {
        this.viewVendas = viewVendas;
    }

    //método que carrega a combo Funcionário
    public void carregarComboFuncionario() {
        FuncionarioController controller = new FuncionarioController();
        try {
            listaFuncionarios = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewVendas.getJcbFuncionario().removeAllItems();
        this.viewVendas.getJcbFuncionario().addItem(Mensagem.defaultComboFuncionario);
        for (Funcionario funcionario : listaFuncionarios) {
            this.viewVendas.getJcbFuncionario().addItem(funcionario.getPessoaFisicaIdPessoaFisica().getNome());
        }
    }

    public void carregarComboProduto() {
        ProdutoController controller = new ProdutoController();
        listaProdutos = controller.buscarProdutos();
        this.viewVendas.getJcbProduto().removeAllItems();
        this.viewVendas.getJcbProduto().addItem(Mensagem.defaultComboProduto);
        for (Produto produto : listaProdutos) {
            this.viewVendas.getJcbProduto().addItem(produto.getDescricao());
        }
    }

    //Método que carrega a combo cliente
    public void carregarComboCliente() {
        ClienteController controller = new ClienteController();
        try {
            listaClientes = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewVendas.getJcbCliente().removeAllItems();
        this.viewVendas.getJcbCliente().addItem(Mensagem.defaultComboCliente);
        for (Cliente cliente : listaClientes) {
            if (cliente.getTipoPessoa().equals("F")) {
                this.viewVendas.getJcbCliente().addItem(cliente.getPessoaFisicaIdPessoaFisica().getNome());
            } else {
                this.viewVendas.getJcbCliente().addItem(cliente.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
            }
        }
    }

    // método de bloqueio inicial da tela
    public void bloqueioInicial() {

        this.viewVendas.getJcbCliente().setEnabled(true);
        this.viewVendas.getJcbCliente().grabFocus();
        this.viewVendas.getJcbFuncionario().setEnabled(true);
        this.viewVendas.getJbtAdicionarProduto().setEnabled(false);
        this.viewVendas.getJbtExcluirFormaDePagamento().setEnabled(false);
        this.viewVendas.getJtfDescontoProduto().setEditable(false);
        this.viewVendas.getJtfQuantidade().setEditable(false);
        this.viewVendas.getJcbProduto().setEnabled(false);
        this.viewVendas.getJcbFormaDePagamento().setEnabled(false);
        this.viewVendas.getJbtIncluirFormaDePagamento().setEnabled(false);
        this.viewVendas.getJbtExcluirFormaDePagamento().setEnabled(false);
        this.viewVendas.getJtfDescontoPagamento().setEditable(false);
        this.viewVendas.getJbtConfirmar().setEnabled(false);
        this.viewVendas.getJbtCancelar().setEnabled(false);
        this.viewVendas.getJbtExcluirProduto().setEnabled(false);
        this.viewVendas.getTabelaPagamento().setEnabled(false);
        this.viewVendas.getTabelaProduto().setEnabled(false);
        this.viewVendas.getJbtIniciarVenda().setEnabled(false);
    }

//Metodo para liberar a venda
    public void liberarIniciarVenda() {
        if ((this.viewVendas.getJcbFuncionario().getSelectedIndex() != 0) && this.viewVendas.getJcbCliente().getSelectedIndex() != 0) {
            this.viewVendas.getJbtIniciarVenda().setEnabled(true);
        } else {
            this.viewVendas.getJbtIniciarVenda().setEnabled(false);
        }
        if (!this.viewVendas.getJbtIniciarVenda().isEnabled()) {
            desabilitarProduto();
        }
    }

    //Método inserirProduto
    public void inserirProduto() {
        if (this.viewVendas.getJcbProduto().getSelectedIndex() != 0) {
            Produto produto = listaProdutos.get(this.viewVendas.getJcbProduto().getSelectedIndex() - 1);
            int quantidade = 0;
            if (!Valida.verificarVazio(this.viewVendas.getJtfQuantidade().getText())) {
                quantidade = Integer.parseInt(this.viewVendas.getJtfQuantidade().getText());
            }
            Double desconto = 0.0;
            if (!Valida.verificarVazio(this.viewVendas.getJtfDescontoProduto().getText())) {
                desconto = Double.parseDouble(this.viewVendas.getJtfDescontoProduto().getText());
            }
            Double valorTotal = ((produto.getValorCusto() * quantidade) - desconto);
            DefaultTableModel modelo = (DefaultTableModel) this.viewVendas.getTabelaProduto().getModel();
            modelo.setRowCount(0);
            modelo.addRow(new String[]{this.viewVendas.getJcbProduto().getSelectedItem().toString(), quantidade + " UN", "R$ " + produto.getValorCusto(), "R$ " + this.viewVendas.getJtfDescontoProduto().getText(), "R$ " + valorTotal});
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProdutoIdProduto(produto);
            itemVenda.setVendaIdVenda(venda);
            itemVenda.setQuantidadeProduto(quantidade);
            itemVenda.setValorTotal(valorTotal);
            listaItemVenda.add(itemVenda);
            habilitarFormaPagamento();
            campoValorTotal();
        } else {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado);
        }
    }

//Método excluirProduto
    public void excluirProduto() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewVendas.getTabelaProduto().getModel();
        if (this.viewVendas.getTabelaProduto().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado);
        } else {
            listaItemVenda.remove(this.viewVendas.getTabelaProduto().getSelectedRow());
            modelo.removeRow(this.viewVendas.getTabelaProduto().getSelectedRow());
            desabilitarFormaPagamento();
            campoValorTotal();
        }
    }

    // Método habilitarFormaPagamento
    public void habilitarFormaPagamento() {
        if (this.viewVendas.getTabelaProduto().getRowCount() > 0) {
            this.viewVendas.getJcbFormaDePagamento().setEnabled(true);
            this.viewVendas.getJcbFormaDePagamento().grabFocus();
            this.viewVendas.getJtfDescontoPagamento().setEditable(true);
            this.viewVendas.getJbtIncluirFormaDePagamento().setEnabled(true);
            this.viewVendas.getJbtExcluirFormaDePagamento().setEnabled(true);
            this.viewVendas.getTabelaPagamento().setEnabled(true);
        }
    }

// Método dasabilitarFormaPagamento
    public void desabilitarFormaPagamento() {
        if (this.viewVendas.getTabelaProduto().getRowCount() == 0) {
            this.viewVendas.getJcbFormaDePagamento().setEnabled(false);
            this.viewVendas.getJtfDescontoPagamento().setEditable(false);
            this.viewVendas.getJbtIncluirFormaDePagamento().setEnabled(false);
            this.viewVendas.getJbtExcluirFormaDePagamento().setEnabled(false);
            this.viewVendas.getTabelaPagamento().setEnabled(false);
        }
    }

// Método inserirFormaPagamento
    public void inserirFormaPagamento() {
        if (this.viewVendas.getJcbProduto().getSelectedIndex() != 0) {
            DefaultTableModel modelo = (DefaultTableModel) this.viewVendas.getTabelaPagamento().getModel();
            modelo.setRowCount(0);
            modelo.addRow(new String[]{this.viewVendas.getJcbFormaDePagamento().getSelectedItem().toString()});
        } else {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado);
        }
    }

    public void removerFormaPagamento() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewVendas.getTabelaPagamento().getModel();
        if (this.viewVendas.getTabelaPagamento().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado);
        } else {
            modelo.removeRow(this.viewVendas.getTabelaPagamento().getSelectedRow());
        }

    }

    //Método acaoBotaoIniciarVenda    
    public void acaoBotaoIniciarVenda() {
        desabilitaDados();
        habilitarProduto();
        Cliente cliente = listaClientes.get(this.viewVendas.getJcbCliente().getSelectedIndex() - 1);
        Funcionario funcionario = listaFuncionarios.get(this.viewVendas.getJcbFuncionario().getSelectedIndex() - 1);
        venda = new Venda();
        venda.setDataVenda(LocalDate.now() + "");
        venda.setValorTotal(0);
        venda.setFormaPagamento("0");
        venda.setClienteIdCliente(cliente);
        venda.setFuncionarioIdFuncionario(funcionario);
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.salvar(venda);

    }

    public void desabilitaDados() {
        this.viewVendas.getJcbCliente().setEnabled(false);
        this.viewVendas.getJcbFuncionario().setEnabled(false);
        this.viewVendas.getJbtIniciarVenda().setEnabled(false);
    }

    // Método habilitaProduto   
    public void habilitarProduto() {
        this.viewVendas.getJcbProduto().setEnabled(true);
        this.viewVendas.getJcbProduto().grabFocus();
        this.viewVendas.getJbtCancelar().setEnabled(true);
        this.viewVendas.getJtfQuantidade().setEditable(true);
        this.viewVendas.getJtfDescontoProduto().setEditable(true);
        this.viewVendas.getJbtAdicionarProduto().setEnabled(true);
        this.viewVendas.getJbtExcluirProduto().setEnabled(true);
        this.viewVendas.getTabelaProduto().setEnabled(true);
    }

    // Método dasabilitarProduto
    public void desabilitarProduto() {
        this.viewVendas.getJcbProduto().setEnabled(false);
        this.viewVendas.getJbtCancelar().setEnabled(false);
        this.viewVendas.getJtfQuantidade().setEditable(false);
        this.viewVendas.getJtfDescontoProduto().setEditable(false);
        this.viewVendas.getJbtAdicionarProduto().setEnabled(false);
        this.viewVendas.getJbtExcluirProduto().setEnabled(false);
        this.viewVendas.getTabelaProduto().setEnabled(false);
    }

    public void campoValorTotal() {
        Double valorTotal = 0.0;
        Double desconto = 0.0;
        desconto = Double.parseDouble(this.viewVendas.getJtfDescontoPagamento().getText());
        if (desconto < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.descontoMenorQueZero);
        }
        for (ItemVenda itemVenda : listaItemVenda) {
            valorTotal += itemVenda.getValorTotal();
        }
        if ((valorTotal - desconto) < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.valorMenorQueZero);
        } else {
            this.viewVendas.getJlbValorTotal().setText("R$ " + (valorTotal - desconto));
        }
    }

    public void acaoBotaoCancelar() {
        int x = JOptionPane.showConfirmDialog(null, Mensagem.confirmaCancelar, Mensagem.atencao,
                JOptionPane.YES_NO_OPTION);
        if ((x == JOptionPane.YES_OPTION)) {
            //* limpar os campos do painel forma de pagamento, produto e dados da compra
            limparDados();
            limparProduto();
            limparFormaPagamento();
            //* excluir a compra gerada pelo botão iniciar compra
            cancelarVenda();
            //* voltar a tela ao estado inicial igual quando foi aberta
            bloqueioInicial();
        }
    }

    public void limparDados() {
        carregarComboCliente();
        carregarComboFuncionario();
    }

    public void limparProduto() {
        carregarComboProduto();
        this.viewVendas.getJtfQuantidade().setText("0");
        this.viewVendas.getJtfDescontoProduto().setText("0.0");
        DefaultTableModel modelo = (DefaultTableModel) this.viewVendas.getTabelaProduto().getModel();
        modelo.setRowCount(0);
        listaItemVenda.clear();
    }

    public void limparFormaPagamento() {
        this.viewVendas.getJcbFormaDePagamento().setSelectedIndex(0);
        this.viewVendas.getJtfDescontoPagamento().setText("0.0");
        DefaultTableModel modelo = (DefaultTableModel) this.viewVendas.getTabelaPagamento().getModel();
        modelo.setRowCount(0);
    }

    public void cancelarVenda() {
        VendaDAO dao = new VendaDAO();
        try {
            dao.excluir(venda);
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void habilitaConfirmar() {
        if (this.viewVendas.getTabelaPagamento().getRowCount() > 0) {
            this.viewVendas.getJbtConfirmar().setEnabled(true);
        } else {
            this.viewVendas.getJbtConfirmar().setEnabled(false);
        }

    }

    public void salvar() {
        if ((this.viewVendas.getJcbFormaDePagamento().getSelectedItem().equals("Dinheiro")) || (this.viewVendas.getJcbFormaDePagamento().getSelectedItem().equals("Débito"))) {
            ItemVendaDAO dao = new ItemVendaDAO();
            VendaDAO vendaDAO = new VendaDAO();
            ContasReceberDAO contasReceberDAO = new ContasReceberDAO();
            ContasReceber conta = new ContasReceber();
            conta.setVendaIdVenda(venda);
            conta.setDataPagamento(LocalDate.now() + "");
            conta.setDataVencimento(LocalDate.now() + "");
            conta.setPagamento("Sim");
            conta.setVencida("Não");
            contasReceberDAO.salvar(conta);
            venda.setFormaPagamento(this.viewVendas.getJcbFormaDePagamento().getSelectedItem().toString());
            venda.setValorTotal (Double.parseDouble(this.viewVendas.getJlbValorTotal().getText()));
            vendaDAO.salvar(venda);
        } else if ((this.viewVendas.getJcbFormaDePagamento().getSelectedItem().equals("Cheque")) || (this.viewVendas.getJcbFormaDePagamento().getSelectedItem().equals("Crédito"))) {
            ItemVendaDAO dao = new ItemVendaDAO();
            VendaDAO vendaDAO = new VendaDAO();
            venda.setFormaPagamento(this.viewVendas.getJcbFormaDePagamento().getSelectedItem().toString());
            venda.setValorTotal(Double.parseDouble(this.viewVendas.getJlbValorTotal().getText()));
            vendaDAO.salvar(venda);
            new ConfirmarContasReceber(venda);
            this.viewVendas.dispose();
        }
    }

}//fim da classe
