package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.CompraDAO;
import br.com.foursys.vendas.dao.ContasPagarDAO;
import br.com.foursys.vendas.dao.ItemCompraDAO;
import br.com.foursys.vendas.model.Compra;
import br.com.foursys.vendas.model.ContasPagar;
import br.com.foursys.vendas.model.Fornecedor;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.ItemCompra;
import br.com.foursys.vendas.model.Produto;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.ComprasPrincipal;
import br.com.foursys.vendas.view.ConfirmarContasPagar;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por controlar todo o processamento de dados relacionados a
 * tela e a tabela de compras e item compras do banco de dados
 *
 * @authors vfurtado, pbido
 * @since 17/03/2020
 * @version 0.1
 */
public class ComprasController {

    private ComprasPrincipal viewCompras;
    private Compra compra = new Compra();
    private List<Produto> listaProdutos;
    private List<ItemCompra> listaItemCompra = new ArrayList<>();
    private List<Fornecedor> listaFornecedores;
    private List<Funcionario> listaFuncionarios;

    public ComprasController() {

    }

    public ComprasController(ComprasPrincipal viewCompras) {
        this.viewCompras = viewCompras;
    }

    public void carregarComboFornecedor() {
        FornecedorController controller = new FornecedorController();
        try {
            listaFornecedores = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewCompras.getJcbFornecedor().removeAllItems();
        this.viewCompras.getJcbFornecedor().addItem(Mensagem.defaultComboFornecedor);
        for (Fornecedor fornecedor : listaFornecedores) {
            this.viewCompras.getJcbFornecedor().addItem(fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        }
    }

    public void carregarComboFuncionario() {
        FuncionarioController controller = new FuncionarioController();
        try {
            listaFuncionarios = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewCompras.getJcbFuncionario().removeAllItems();
        this.viewCompras.getJcbFuncionario().addItem(Mensagem.defaultComboFuncionario);
        for (Funcionario fornecedor : listaFuncionarios) {
            this.viewCompras.getJcbFuncionario().addItem(fornecedor.getPessoaFisicaIdPessoaFisica().getNome());
        }
    }

    public void carregarComboProduto() {
        ProdutoController controller = new ProdutoController();
        listaProdutos = controller.buscarProdutos();
        this.viewCompras.getJcbProduto().removeAllItems();
        this.viewCompras.getJcbProduto().addItem(Mensagem.defaultComboProduto);
        for (Produto produto : listaProdutos) {
            this.viewCompras.getJcbProduto().addItem(produto.getDescricao());
        }
    }

    //* Campos que estarao bloqueados ao abrir a tela
    public void bloqueioInicial() {
        this.viewCompras.getJcbFuncionario().grabFocus();
        this.viewCompras.getJcbFuncionario().setEnabled(true);
        this.viewCompras.getJcbFornecedor().setEnabled(true);
        this.viewCompras.getJbtIniciarCompra().setEnabled(false);
        this.viewCompras.getJcbProduto().setEnabled(false);
        this.viewCompras.getJtfQuantidade().setEditable(false);
        this.viewCompras.getJtfDescontoProduto().setEditable(false);
        this.viewCompras.getJbtAdicionarProduto().setEnabled(false);
        this.viewCompras.getJbtExcluirProduto().setEnabled(false);
        this.viewCompras.getTabelaProdutos().setEnabled(false);
        this.viewCompras.getJcbFormaPagamento().setEnabled(false);
        this.viewCompras.getJtfDescontoPagamento().setEditable(false);
        this.viewCompras.getJbtIncluirFormaPagamento().setEnabled(false);
        this.viewCompras.getJbtExcluirFormaPagamento().setEnabled(false);
        this.viewCompras.getTabelaFormaPagamento().setEnabled(false);
        this.viewCompras.getJbtConfirmar().setEnabled(false);
        this.viewCompras.getJbtCancelar().setEnabled(false);
        this.viewCompras.getJbtSair().setEnabled(true);
    }

    //* Habilita o botão iniciar compra quando foi escolhido um fornecedor e um funcionário
    //* Falta fazer a validação pra caso o usuário habilite o botão e mude o que está selecionado na combo
    //* ideia: carregar o usuario como funcionário padrão e deixar desabilitado ?
    public void liberaIniciarCompra() {
        if ((this.viewCompras.getJcbFuncionario().getSelectedIndex() != 0) && this.viewCompras.getJcbFornecedor().getSelectedIndex() != 0) {
            this.viewCompras.getJbtIniciarCompra().setEnabled(true);
        } else {
            this.viewCompras.getJbtIniciarCompra().setEnabled(false);
        }
        if (!this.viewCompras.getJbtIniciarCompra().isEnabled()) {
            desabilitaProduto();
        }
    }

    //* Quando inserir um produto na tabela, adicionar o produto numa lista para poder salvar essa lista de produtos
    //  no banco de dados posteriormente
    public void inserirProduto() {
        if (this.viewCompras.getJcbProduto().getSelectedIndex() != 0) {
            Produto produto = listaProdutos.get(this.viewCompras.getJcbProduto().getSelectedIndex() - 1);
            int quantidade = 0;
            if (!Valida.verificarVazio(this.viewCompras.getJtfQuantidade().getText())) {
                quantidade = Integer.parseInt(this.viewCompras.getJtfQuantidade().getText());
            }
            Double desconto = 0.0;
            if (!Valida.verificarVazio(this.viewCompras.getJtfDescontoProduto().getText())) {
                desconto = Double.parseDouble(this.viewCompras.getJtfDescontoProduto().getText());
            }
            Double valorTotal = ((produto.getValorCusto() * quantidade) - desconto);
            DefaultTableModel modelo = (DefaultTableModel) this.viewCompras.getTabelaProdutos().getModel();
            modelo.addRow(new String[]{this.viewCompras.getJcbProduto().getSelectedItem().toString(), quantidade + " UN", "R$ " + produto.getValorCusto(), "R$ " + this.viewCompras.getJtfDescontoProduto().getText(), "R$ " + valorTotal});
            ItemCompra itemCompra = new ItemCompra();
            itemCompra.setProdutoIdProduto(produto);
            itemCompra.setCompraIdCompra(compra);
            itemCompra.setQuantidadeProduto(quantidade + "");
            itemCompra.setValorTotal(valorTotal);
            listaItemCompra.add(itemCompra);
            ItemCompraDAO itemCompraDAO = new ItemCompraDAO();
            itemCompraDAO.salvar(itemCompra);
            habilitarFormaPagamento();
            campoValorTotal();
        } else {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado);
        }
    }

    //* assim como no inserir, o excluir deve remover o produto selecionado na tabela da lista na qual estamos
    //  salvando todos os produtos inseridos
    //* ideia: o método deveria se chamar remover produto já que não estamos fazendo uma exclusão, mas apenas removendo
    //  da tabela para que ele não seja constado na compra
    public void excluirProduto() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCompras.getTabelaProdutos().getModel();
        if (this.viewCompras.getTabelaProdutos().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado);
        } else {
            listaItemCompra.remove(this.viewCompras.getTabelaProdutos().getSelectedRow());
            modelo.removeRow(this.viewCompras.getTabelaProdutos().getSelectedRow());
            desabilitarFormaPagamento();
            campoValorTotal();
        }

    }

    public void habilitarFormaPagamento() {
        if (this.viewCompras.getTabelaProdutos().getRowCount() > 0) {
            this.viewCompras.getJcbFormaPagamento().setEnabled(true);
            this.viewCompras.getJtfDescontoPagamento().setEditable(true);
            this.viewCompras.getJbtIncluirFormaPagamento().setEnabled(true);
            this.viewCompras.getJbtExcluirFormaPagamento().setEnabled(true);
            this.viewCompras.getTabelaFormaPagamento().setEnabled(true);
        }
    }

    public void desabilitarFormaPagamento() {
        if (this.viewCompras.getTabelaProdutos().getRowCount() == 0) {
            this.viewCompras.getJcbFormaPagamento().setEnabled(false);
            this.viewCompras.getJtfDescontoPagamento().setEditable(false);
            this.viewCompras.getJbtIncluirFormaPagamento().setEnabled(false);
            this.viewCompras.getJbtExcluirFormaPagamento().setEnabled(false);
            this.viewCompras.getTabelaFormaPagamento().setEnabled(false);
        }
    }

    //* ideia: aqui como podemos adicionar um unico registro à tabela, ela pode ser apenas visual enquanto usamos
    //  o que está selecionado na combobox para salvar
    // inserir forma de pagamento
    public void inserirFormaPagamento() {
        if (this.viewCompras.getJcbProduto().getSelectedIndex() != 0) {
            DefaultTableModel modelo = (DefaultTableModel) this.viewCompras.getTabelaFormaPagamento().getModel();
            modelo.setRowCount(0);
            modelo.addRow(new String[]{this.viewCompras.getJcbFormaPagamento().getSelectedItem().toString()});
            habilitaConfirmar();
        } else {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado);
        }
    }

    public void removerFormaPagamento() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCompras.getTabelaFormaPagamento().getModel();
        if (this.viewCompras.getTabelaFormaPagamento().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado);
        } else {
            modelo.removeRow(this.viewCompras.getTabelaFormaPagamento().getSelectedRow());
            habilitaConfirmar();
        }

    }

    //* o botão iniciar compra não pode ser pressionado mais de uma vez em uma compra já que ele gera um registro no banco
    //  nao podemos dar essa permissão pro usuário.
    public void acaoBotaoIniciarCompra() {
        desabilitaDados();
        habilitaProduto();
        Fornecedor fornecedor = listaFornecedores.get(this.viewCompras.getJcbFornecedor().getSelectedIndex() - 1);
        Funcionario funcionario = listaFuncionarios.get(this.viewCompras.getJcbFuncionario().getSelectedIndex() - 1);
        compra = new Compra();
        compra.setDataCompra(LocalDate.now() + "");
        compra.setValorTotal("0");
        compra.setFormaPagamento("0");
        compra.setFornecedorIdFornecedor(fornecedor);
        compra.setFuncionarioIdFuncionario(funcionario);
        CompraDAO compraDAO = new CompraDAO();
        compraDAO.salvar(compra);
    }

    public void desabilitaDados() {
        this.viewCompras.getJcbFornecedor().setEnabled(false);
        this.viewCompras.getJcbFuncionario().setEnabled(false);
        this.viewCompras.getJbtIniciarCompra().setEnabled(false);
    }

    public void habilitaProduto() {
        this.viewCompras.getJcbProduto().setEnabled(true);
        this.viewCompras.getJbtCancelar().setEnabled(true);
        this.viewCompras.getJtfQuantidade().setEditable(true);
        this.viewCompras.getJtfDescontoProduto().setEditable(true);
        this.viewCompras.getJbtAdicionarProduto().setEnabled(true);
        this.viewCompras.getJbtExcluirProduto().setEnabled(true);
        this.viewCompras.getTabelaProdutos().setEnabled(true);
    }

    public void desabilitaProduto() {
        this.viewCompras.getJcbProduto().setEnabled(false);
        this.viewCompras.getJbtCancelar().setEnabled(false);
        this.viewCompras.getJtfQuantidade().setEditable(false);
        this.viewCompras.getJtfDescontoProduto().setEditable(false);
        this.viewCompras.getJbtAdicionarProduto().setEnabled(false);
        this.viewCompras.getJbtExcluirProduto().setEnabled(false);
        this.viewCompras.getTabelaProdutos().setEnabled(false);
    }

    public void campoValorTotal() {
        Double valorTotal = 0.0;
        Double desconto = 0.0;
        try {
            desconto = Double.parseDouble(this.viewCompras.getJtfDescontoPagamento().getText());
        } catch (NumberFormatException e) {
            this.viewCompras.getJtfDescontoPagamento().setText("0.0");
        }
        if (desconto < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.descontoMenorQueZero);
        }
        for (ItemCompra itemCompra : listaItemCompra) {
            valorTotal += itemCompra.getValorTotal();
        }
        if ((valorTotal - desconto) < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.valorMenorQueZero);
        } else {
            this.viewCompras.getJlbValorTotal().setText("R$ " + (valorTotal - desconto));
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
            cancelarCompra();
            //* voltar a tela ao estado inicial igual quando foi aberta
            bloqueioInicial();
        }
    }

    public void limparDados() {
        carregarComboFornecedor();
        carregarComboFuncionario();
    }

    public void limparProduto() {
        carregarComboProduto();
        this.viewCompras.getJtfQuantidade().setText("0");
        this.viewCompras.getJtfDescontoProduto().setText("0.0");
        DefaultTableModel modelo = (DefaultTableModel) this.viewCompras.getTabelaProdutos().getModel();
        modelo.setRowCount(0);
        listaItemCompra.clear();
    }

    public void limparFormaPagamento() {
        this.viewCompras.getJcbFormaPagamento().setSelectedIndex(0);
        this.viewCompras.getJtfDescontoPagamento().setText("0.0");
        DefaultTableModel modelo = (DefaultTableModel) this.viewCompras.getTabelaFormaPagamento().getModel();
        modelo.setRowCount(0);
    }

    public void cancelarCompra() {
        CompraDAO dao = new CompraDAO();
        new ItemCompraController().excluirItemCompra(compra);
        try {
            dao.excluir(compra);
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void habilitaConfirmar() {
        if (this.viewCompras.getTabelaFormaPagamento().getRowCount() > 0) {
            this.viewCompras.getJbtConfirmar().setEnabled(true);
        } else {
            this.viewCompras.getJbtConfirmar().setEnabled(false);
        }

    }

    public void salvar() {
        if ((this.viewCompras.getJcbFormaPagamento().getSelectedItem().equals("Dinheiro")) || (this.viewCompras.getJcbFormaPagamento().getSelectedItem().equals("Débito"))) {
            ItemCompraDAO dao = new ItemCompraDAO();
            CompraDAO compraDAO = new CompraDAO();
            ContasPagarDAO contasPagarDAO = new ContasPagarDAO();
            ContasPagar conta = new ContasPagar();
            conta.setCompraIdCompra(compra);
            conta.setDataPagamento(LocalDate.now() + "");
            conta.setDataVencimento(LocalDate.now() + "");
            conta.setPagamento("Sim");
            conta.setVencida("Não");
            contasPagarDAO.salvar(conta);
            compra.setFormaPagamento(this.viewCompras.getJcbFormaPagamento().getSelectedItem().toString());
            compra.setValorTotal(this.viewCompras.getJlbValorTotal().getText());
            compraDAO.salvar(compra);
        } else if ((this.viewCompras.getJcbFormaPagamento().getSelectedItem().equals("Cheque")) || (this.viewCompras.getJcbFormaPagamento().getSelectedItem().equals("Crédito"))) {
            ItemCompraDAO dao = new ItemCompraDAO();
            CompraDAO compraDAO = new CompraDAO();
            compra.setFormaPagamento(this.viewCompras.getJcbFormaPagamento().getSelectedItem().toString());
            compra.setValorTotal(this.viewCompras.getJlbValorTotal().getText());
            compraDAO.salvar(compra);
            new ConfirmarContasPagar(compra);
            this.viewCompras.dispose();
        }
    }
}
