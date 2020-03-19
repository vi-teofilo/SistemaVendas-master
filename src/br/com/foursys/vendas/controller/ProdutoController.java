package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ProdutoDAO;
import br.com.foursys.vendas.model.Produto;
import br.com.foursys.vendas.model.Fornecedor;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.ProdutoPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por controlar todo o processamento de dados relacionados à
 * tela e tabela de produtoes do sistema de vendas
 *
 * @author pbido
 * @since 12/03/2020
 * @version 0.1
 */
public class ProdutoController {

    private ProdutoPrincipal viewProduto;
    private Produto produto = new Produto();
    private List<Produto> listaProdutos;
    private List<Fornecedor> listaFornecedores;
    private boolean alterar;

    public ProdutoController() {

    }

    public ProdutoController(ProdutoPrincipal viewProduto) {
        this.viewProduto = viewProduto;
    }
// metodos responsaveis por salvar ,alterar e excluir produto
    public void salvarProduto() {
        if (this.alterar == false) {
            if (validarSalvar()) {
                Produto produto = new Produto();
                produto.setDescricao(this.viewProduto.getJtfDescricao().getText());
                Fornecedor fornecedor = listaFornecedores.get(this.viewProduto.getJcbFornecedor().getSelectedIndex() - 1);
                produto.setFornecedorIdFornecedor(fornecedor);
                produto.setValorCusto(Double.parseDouble(this.viewProduto.getJtfValorCusto().getText()));
                produto.setValorVenda(Double.parseDouble(this.viewProduto.getJtfValorVenda().getText()));
                ProdutoDAO dao = new ProdutoDAO();
                try {
                    dao.salvar(produto);
                    JOptionPane.showMessageDialog(null, Mensagem.produtoInseridoSucesso);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.produtoInseridoErro);
                    Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarProdutos();
            }
        } else {
            if (validarSalvar()) {
                produto.setDescricao(this.viewProduto.getJtfDescricao().getText());
                Fornecedor fornecedor;
                fornecedor = listaFornecedores.get(this.viewProduto.getJcbFornecedor().getSelectedIndex() - 1);
                produto.getFornecedorIdFornecedor().setIdFornecedor(fornecedor.getIdFornecedor());
                produto.setValorCusto(Double.parseDouble(this.viewProduto.getJtfValorCusto().getText()));
                produto.setValorVenda(Double.parseDouble(this.viewProduto.getJtfValorVenda().getText()));
                ProdutoDAO dao = new ProdutoDAO();
                try {
                    dao.salvar(produto);
                    JOptionPane.showMessageDialog(null, Mensagem.produtoAlteradoSucesso);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.produtoAlteradoErro);
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarProdutos();

            }
        }
    }
     public void alterarProduto() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewProduto.getTabelaProduto().getModel();
        if (this.viewProduto.getTabelaProduto().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado);
        } else {
            produto = listaProdutos.get(this.viewProduto.getTabelaProduto().getSelectedRow());
            this.viewProduto.getJtfDescricao().setText(produto.getDescricao());
            this.viewProduto.getJtfValorCusto().setText(produto.getValorCusto() + "");
            this.viewProduto.getJtfValorVenda().setText(produto.getValorVenda() + "");
            this.viewProduto.getJcbFornecedor().setSelectedItem(produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
            this.alterar = true;
            acaoBotaoAlterar();
        }
    }

    public void excluirProduto() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewProduto.getTabelaProduto().getModel();
        if (this.viewProduto.getTabelaProduto().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado);
        } else {
            produto = listaProdutos.get(this.viewProduto.getTabelaProduto().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExclusao, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                ProdutoDAO dao = new ProdutoDAO();
                try {
                    dao.excluir(produto);
                    JOptionPane.showMessageDialog(null, Mensagem.produtoExcluidoSucesso);
                    listarProdutos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.produtoExcluidoErro);
                    Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
//    Metodos responsaveis por listar, buscar e carregar tabela
    public List<Produto> buscarProdutos() {

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> listaProdutos = new ArrayList<Produto>();

        try {
            listaProdutos = dao.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaProdutos;
    }

    public void listarProdutos() {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            listaProdutos = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewProduto.getTabelaProduto().getModel();
        modelo.setRowCount(0);
        for (Produto produto : listaProdutos) {
            modelo.addRow(new String[]{produto.getDescricao(), produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(), produto.getValorCusto() + "", produto.getValorVenda() + ""});
        }
    }
// metodos responsavel por popular as combos 
    public void carregarComboFornecedor() {
        FornecedorController controller = new FornecedorController();
        try {
            listaFornecedores = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewProduto.getJcbFornecedor().removeAllItems();
        this.viewProduto.getJcbFornecedor().addItem(Mensagem.defaultComboFornecedor);
        for (Fornecedor fornecedor : listaFornecedores) {
            this.viewProduto.getJcbFornecedor().addItem(fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        }
    }
// metodos responsavel por colocar ação na tela 
    public void bloqueioInicial() {
        this.viewProduto.getJbtNovo().setEnabled(true);
        this.viewProduto.getJbtAlterar().setEnabled(true);
        this.viewProduto.getJbtExcluir().setEnabled(true);
        this.viewProduto.getJbtSair().setEnabled(true);
        this.viewProduto.getJbtSalvar().setEnabled(false);
        this.viewProduto.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewProduto.getJtfPesquisarDescricao().setEditable(true);
        this.viewProduto.getJtfPesquisarDescricao().grabFocus();
        this.viewProduto.getJtfDescricao().setEditable(false);
        this.viewProduto.getJcbFornecedor().setEnabled(false);
        this.viewProduto.getJtfValorCusto().setEditable(false);
        this.viewProduto.getJtfValorVenda().setEditable(false);
    }

    public void liberarCampos() {
        this.viewProduto.getJtfPesquisarDescricao().setEditable(false);
        this.viewProduto.getJtfDescricao().setEditable(true);
        this.viewProduto.getJtfDescricao().grabFocus();
        this.viewProduto.getJcbFornecedor().setEnabled(true);
        this.viewProduto.getJtfValorCusto().setEditable(true);
        this.viewProduto.getJtfValorVenda().setEditable(true);
    }

    public void limparCampos() {
        this.viewProduto.getJtfPesquisarDescricao().setText(null);
        this.viewProduto.getJtfDescricao().setText(null);
        this.viewProduto.getJtfValorCusto().setText(null);
        this.viewProduto.getJtfValorVenda().setText(null);
        this.viewProduto.getJcbFornecedor().setSelectedIndex(0);
    }

    public void acaoBotaoCancelar() {
        this.viewProduto.getJtfPesquisarDescricao().setEditable(true);
        this.viewProduto.getJtfPesquisarDescricao().grabFocus();
        this.viewProduto.getJbtNovo().setEnabled(true);
        this.viewProduto.getJbtAlterar().setEnabled(true);
        this.viewProduto.getJbtExcluir().setEnabled(true);
        this.viewProduto.getJbtSair().setEnabled(true);
        this.viewProduto.getJbtSalvar().setEnabled(false);
        this.viewProduto.getJbtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void acaoBotaoNovo() {
        this.viewProduto.getJbtNovo().setEnabled(false);
        this.viewProduto.getJbtAlterar().setEnabled(false);
        this.viewProduto.getJbtExcluir().setEnabled(false);
        this.viewProduto.getJtfPesquisarDescricao().setEditable(false);
        this.viewProduto.getJbtSair().setEnabled(false);
        this.viewProduto.getJbtSalvar().setEnabled(true);
        this.viewProduto.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }
     public void acaoBotaoAlterar() {
        this.viewProduto.getJbtNovo().setEnabled(false);
        this.viewProduto.getJbtAlterar().setEnabled(false);
        this.viewProduto.getJbtExcluir().setEnabled(false);
        this.viewProduto.getJbtSair().setEnabled(false);
        this.viewProduto.getJbtSalvar().setEnabled(true);
        this.viewProduto.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewProduto.getJtfDescricao().setEditable(false);

    }
// metodo responsavel por fazer as validações necessarias  
    public boolean validarSalvar() {
        if (Valida.verificarVazio(this.viewProduto.getJtfDescricao().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoDescricaoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewProduto.getJtfDescricao().grabFocus();
            return false;
        } else if (Valida.verificarCombo(this.viewProduto.getJcbFornecedor().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoFornecedorVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewProduto.getJcbFornecedor().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewProduto.getJtfValorCusto().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoValorCustoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewProduto.getJtfValorCusto().grabFocus();
            return false;
        } else if (!Valida.validarNumero(this.viewProduto.getJtfValorCusto().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoValorCustoInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewProduto.getJtfValorCusto().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewProduto.getJtfValorVenda().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoValorVendaVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewProduto.getJtfValorVenda().grabFocus();
            return false;
        } else if (!Valida.validarNumero(this.viewProduto.getJtfValorVenda().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoValorVendaInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewProduto.getJtfValorVenda().grabFocus();
            return false;
        }
        return true;
    }

    

   

   
}
