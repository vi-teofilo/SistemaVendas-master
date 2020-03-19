package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.EstoqueDAO;
import br.com.foursys.vendas.model.Estoque;
import br.com.foursys.vendas.model.Produto;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.EstoquePrincipal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por controlar todo o processamento de dados relacionados à
 * tela e tabela de estoque do sistema de vendas
 *
 * @author pbido
 *
 */
public class EstoqueController {

    private EstoquePrincipal viewEstoque;
    private Estoque estoque = new Estoque();
    private List<Estoque> listaEstoques;
    private List<Produto> listaProdutos;
    private boolean alterar;

    public EstoqueController() {

    }

    public EstoqueController(EstoquePrincipal viewEstoque) {
        this.viewEstoque = viewEstoque;
    }
// metodos responsaveis por salvar ,alterar e excluir estoque

    public void salvarEstoque() {
        if (this.alterar == false) {
//            salvar 
            if (validarSalvar()) {
                Estoque estoque = new Estoque();

                estoque.setQuantidadeEstoque(Integer.parseInt(this.viewEstoque.getJtfQtde().getText()));
                estoque.setQuantidadeMinima(Integer.parseInt(this.viewEstoque.getJtfQtdeMin().getText()));
                Produto produto = listaProdutos.get(this.viewEstoque.getJcbProduto().getSelectedIndex() - 1);
                estoque.setProdutoIdProduto(produto);

                EstoqueDAO dao = new EstoqueDAO();
                try {
                    dao.salvar(estoque);
                    JOptionPane.showMessageDialog(null, Mensagem.estoqueInseridoSucesso);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.estoqueInseridoErro);
                    Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarEstoque();
            }
        } else {
//            alterar
            if (validarSalvar()) {

                Produto produto;
                produto = listaProdutos.get(this.viewEstoque.getJcbProduto().getSelectedIndex() - 1);
                estoque.getProdutoIdProduto().setIdProduto(produto.getIdProduto());
                estoque.setQuantidadeEstoque(Integer.parseInt(this.viewEstoque.getJtfQtde().getText()));
                estoque.setQuantidadeMinima(Integer.parseInt(this.viewEstoque.getJtfQtdeMin().getText()));
                EstoqueDAO dao = new EstoqueDAO();
                try {
                    dao.salvar(estoque);
                    JOptionPane.showMessageDialog(null, Mensagem.estoqueAlteradoSucesso);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.estoqueAlteradoErro);
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarEstoque();

            }
        }
    }

    public void alterarEstoque() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewEstoque.getTabelaEstoque().getModel();
        if (this.viewEstoque.getTabelaEstoque().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.estoqueNaoSelecionado);
        } else {
            estoque = listaEstoques.get(this.viewEstoque.getTabelaEstoque().getSelectedRow());
            this.viewEstoque.getJcbProduto().setSelectedItem(estoque.getProdutoIdProduto().getDescricao());
            this.viewEstoque.getJtfQtde().setText(estoque.getQuantidadeEstoque() + "");
            this.viewEstoque.getJlbDescricao().setText(estoque.getProdutoIdProduto().getDescricao() + "");
            this.viewEstoque.getJlbFornecedor().setText(estoque.getProdutoIdProduto().getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
            this.viewEstoque.getJlbValorVenda().setText(estoque.getProdutoIdProduto().getValorVenda() + "");
            this.viewEstoque.getJlbValorCusto().setText(estoque.getProdutoIdProduto().getValorCusto() + "");
            this.viewEstoque.getJtfQtdeMin().setText(estoque.getQuantidadeMinima() + "");
            this.alterar = true;
            acaoBotaoAlterar();
        }
    }

    public void excluirEstoque() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewEstoque.getTabelaEstoque().getModel();
        if (this.viewEstoque.getTabelaEstoque().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.estoqueNaoSelecionado);
        } else {
            estoque = listaEstoques.get(this.viewEstoque.getTabelaEstoque().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExclusao, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                EstoqueDAO dao = new EstoqueDAO();
                try {
                    dao.excluir(estoque);
                    JOptionPane.showMessageDialog(null, Mensagem.estoqueExcluidoSucesso);
                    listarEstoque();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.estoqueExcluidoErro);
                    Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

//    Metodos responsaveis por listar, buscar e carregar tabela
    public void listarEstoque() {
        try {
            EstoqueDAO dao = new EstoqueDAO();
            listaEstoques = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewEstoque.getTabelaEstoque().getModel();
        modelo.setRowCount(0);
        for (Estoque estoque : listaEstoques) {
            modelo.addRow(new String[]{estoque.getProdutoIdProduto().getDescricao(), estoque.getProdutoIdProduto().getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(), estoque.getQuantidadeEstoque() + "", estoque.getQuantidadeMinima() + ""});
        }
    }
// metodos responsavel por popular as combos 

    public void carregarComboProduto() {
        ProdutoController controller = new ProdutoController();
        listaProdutos = controller.buscarProdutos();
        this.viewEstoque.getJcbProduto().removeAllItems();
        this.viewEstoque.getJcbProduto().addItem(Mensagem.defaultComboProduto);
        for (Produto listaProduto : listaProdutos) {
            this.viewEstoque.getJcbProduto().addItem(listaProduto.getDescricao());
        }

    }
// metodos responsavel por colocar ação na tela 

    public void bloqueioInicial() {
        this.viewEstoque.getJbtNovo().setEnabled(true);
        this.viewEstoque.getJbtAlterar().setEnabled(true);
        this.viewEstoque.getJbtExcluir().setEnabled(true);
        this.viewEstoque.getJbtSair().setEnabled(true);
        this.viewEstoque.getJbtSalvar().setEnabled(false);
        this.viewEstoque.getJbtCancelar().setEnabled(false);
        this.viewEstoque.getJtfQtde().setEditable(false);
        this.viewEstoque.getJtfQtdeMin().setEditable(false);
        this.viewEstoque.getJbtSelecionar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewEstoque.getJcbProduto().setEnabled(false);
        this.viewEstoque.getJtfQtde().setEditable(false);
        this.viewEstoque.getJtfQtdeMin().setEditable(false);

    }

    public void liberarCampos() {
        this.viewEstoque.getJcbProduto().setEnabled(true);
        this.viewEstoque.getJcbProduto().grabFocus();
        this.viewEstoque.getJtfQtdeMin().setEditable(true);
        this.viewEstoque.getJtfQtde().setEditable(true);
        this.viewEstoque.getJbtSelecionar().setEnabled(true);
    }

    public void limparCampos() {
        this.viewEstoque.getJcbProduto().setSelectedIndex(0);
        this.viewEstoque.getJlbDescricao().setText("");
        this.viewEstoque.getJlbFornecedor().setText("");
        this.viewEstoque.getJlbValorCusto().setText("");
        this.viewEstoque.getJlbValorVenda().setText("");
        this.viewEstoque.getJtfQtde().setText("");
        this.viewEstoque.getJtfQtdeMin().setText("");
    }

    public void acaoBotaoCancelar() {
        this.viewEstoque.getJbtNovo().setEnabled(true);
        this.viewEstoque.getJbtAlterar().setEnabled(true);
        this.viewEstoque.getJbtExcluir().setEnabled(true);
        this.viewEstoque.getJbtSair().setEnabled(true);
        this.viewEstoque.getJbtSalvar().setEnabled(false);
        this.viewEstoque.getJbtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void acaoBotaoNovo() {
        this.viewEstoque.getJbtNovo().setEnabled(false);
        this.viewEstoque.getJbtAlterar().setEnabled(false);
        this.viewEstoque.getJbtExcluir().setEnabled(false);
        this.viewEstoque.getJbtSair().setEnabled(false);
        this.viewEstoque.getJbtSalvar().setEnabled(true);
        this.viewEstoque.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }

    public void acaoBotaoAlterar() {
        this.viewEstoque.getJbtNovo().setEnabled(false);
        this.viewEstoque.getJbtAlterar().setEnabled(false);
        this.viewEstoque.getJbtExcluir().setEnabled(false);
        this.viewEstoque.getJbtSair().setEnabled(false);
        this.viewEstoque.getJbtSalvar().setEnabled(true);
        this.viewEstoque.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewEstoque.getJcbProduto().setEnabled(false);
        this.viewEstoque.getJbtSelecionar().setEnabled(false);
    }

    public void carregarInformacoes() {

        Produto produto = null;
        produto = listaProdutos.get(this.viewEstoque.getJcbProduto().getSelectedIndex() - 1);
        this.viewEstoque.getJlbDescricao().setText(produto.getDescricao());
        this.viewEstoque.getJlbFornecedor().setText(produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        this.viewEstoque.getJlbValorVenda().setText(produto.getValorVenda() + "");
        this.viewEstoque.getJlbValorCusto().setText(produto.getValorCusto() + "");
    }
// metodo responsavel por fazer as validações necessarias
    public boolean validarSalvar() {
        if (Valida.verificarCombo(this.viewEstoque.getJcbProduto().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoNaoSelecionado, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewEstoque.getJcbProduto().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewEstoque.getJtfQtdeMin().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.estoqueQuantidadeMaximaVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewEstoque.getJtfQtdeMin().grabFocus();
            return false;
        } else if (!Valida.validarNumero(this.viewEstoque.getJtfQtdeMin().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.estoqueQuantidadeMaximaInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewEstoque.getJtfQtdeMin().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewEstoque.getJtfQtde().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.estoqueQuantidadeVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewEstoque.getJtfQtdeMin().grabFocus();
            return false;
        } else if (!Valida.validarNumero(this.viewEstoque.getJtfQtde().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.estoqueQuantidadeInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewEstoque.getJtfQtde().grabFocus();
            return false;
        } else if (Integer.parseInt(this.viewEstoque.getJtfQtde().getText()) < (Integer.parseInt(this.viewEstoque.getJtfQtdeMin().getText()))) {
            JOptionPane.showMessageDialog(null, Mensagem.produtoInsuficiente, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewEstoque.getJtfQtdeMin().grabFocus();
            return false;
        }
        return true;
    }

}
