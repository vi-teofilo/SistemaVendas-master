package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.FornecedorDAO;
import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.model.Fornecedor;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.model.Endereco;
import br.com.foursys.vendas.model.Estado;
import br.com.foursys.vendas.model.PessoaJuridica;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.FornecedorPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por controlar todo o processamento de dados relacionados à
 * tela e tabela de fornecedores do sistema de vendas
 *
 * @author pbido
 * @since 12/03/2020
 * @version 0.1
 */
public class FornecedorController {

    private FornecedorPrincipal viewFornecedor;
    private Fornecedor fornecedor = new Fornecedor();
    private List<Fornecedor> listaFornecedores;
    private List<Cidade> listaCidades;
    private List<Estado> listaEstados;
    private boolean alterar;

    public FornecedorController() {

    }

    public FornecedorController(FornecedorPrincipal viewFornecedor) {
        this.viewFornecedor = viewFornecedor;
    }
// metodos responsaveis por salvar ,alterar e excluir Fornecedor
     public void salvarFornecedor() {
        if (this.alterar == false) {
            if (validarSalvar()) {
                Fornecedor fornecedor = new Fornecedor();
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                Endereco endereco = new Endereco();
                Cidade cidade;
                Contato contato = new Contato();
                pessoaJuridica.setRazaoSocial(this.viewFornecedor.getJtfRazaoSocial().getText());
                pessoaJuridica.setCnpj(this.viewFornecedor.getJtfCnpj().getText());
                pessoaJuridica.setInscricaoEstadual(this.viewFornecedor.getJtfInscricaoEstadual().getText());
                pessoaJuridica.setDataFundacao(this.viewFornecedor.getJtfDataFundacao().getText());
                fornecedor.setPessoaJuridicaIdPessoaJuridica(pessoaJuridica);
                new PessoaJuridicaController().salvarPessoaJuridica(pessoaJuridica);
                endereco.setLogradouro(this.viewFornecedor.getJtfEndereco().getText());
                endereco.setNumero(Integer.parseInt(this.viewFornecedor.getJtfNumero().getText()));
                endereco.setComplemento(this.viewFornecedor.getJtfComplemento().getText());
                endereco.setBairro(this.viewFornecedor.getJtfBairro().getText());
                endereco.setCep(this.viewFornecedor.getJtfCep().getText());
                cidade = listaCidades.get(this.viewFornecedor.getJcbCidade().getSelectedIndex() - 1);
                endereco.setCidadeIdCidade(cidade);
                fornecedor.setEnderecoIdEndereco(endereco);
                new EnderecoController().salvarEndereco(endereco);
                contato.setTelefone(this.viewFornecedor.getJtfTelefone().getText());
                contato.setCelular(this.viewFornecedor.getJtfCelular().getText());
                contato.setEmail(this.viewFornecedor.getJtfEmail().getText());
                fornecedor.setContatoIdContato(contato);
                new ContatoController().salvarContato(contato);
                fornecedor.setContato(this.viewFornecedor.getJtfContato().getText());
                FornecedorDAO dao = new FornecedorDAO();
                try {
                    dao.salvar(fornecedor);
                    JOptionPane.showMessageDialog(null, Mensagem.fornecedorInseridoSucesso);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.fornecedorInseridoErro);
                    Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarFornecedores();
            }
        } else {
            if (validarSalvar()) {
                fornecedor.getPessoaJuridicaIdPessoaJuridica().setRazaoSocial(this.viewFornecedor.getJtfRazaoSocial().getText());
                fornecedor.getPessoaJuridicaIdPessoaJuridica().setCnpj(this.viewFornecedor.getJtfCnpj().getText());
                fornecedor.getPessoaJuridicaIdPessoaJuridica().setInscricaoEstadual(this.viewFornecedor.getJtfInscricaoEstadual().getText());
                fornecedor.getPessoaJuridicaIdPessoaJuridica().setDataFundacao(this.viewFornecedor.getJtfDataFundacao().getText());
                new PessoaJuridicaController().salvarPessoaJuridica(fornecedor.getPessoaJuridicaIdPessoaJuridica());

                fornecedor.getEnderecoIdEndereco().setLogradouro(this.viewFornecedor.getJtfEndereco().getText());
                fornecedor.getEnderecoIdEndereco().setNumero(Integer.parseInt(this.viewFornecedor.getJtfNumero().getText()));
                fornecedor.getEnderecoIdEndereco().setComplemento(this.viewFornecedor.getJtfComplemento().getText());
                fornecedor.getEnderecoIdEndereco().setBairro(this.viewFornecedor.getJtfBairro().getText());
                fornecedor.getEnderecoIdEndereco().setCep(this.viewFornecedor.getJtfCep().getText());

                Cidade cidade;
                cidade = listaCidades.get(this.viewFornecedor.getJcbCidade().getSelectedIndex() - 1);
                fornecedor.getEnderecoIdEndereco().setCidadeIdCidade(cidade);
                new EnderecoController().salvarEndereco(fornecedor.getEnderecoIdEndereco());
                fornecedor.getContatoIdContato().setTelefone(this.viewFornecedor.getJtfTelefone().getText());
                fornecedor.getContatoIdContato().setCelular(this.viewFornecedor.getJtfCelular().getText());
                fornecedor.getContatoIdContato().setEmail(this.viewFornecedor.getJtfEmail().getText());
                new ContatoController().salvarContato(fornecedor.getContatoIdContato());
                fornecedor.setContato(this.viewFornecedor.getJtfContato().getText());
                FornecedorDAO dao = new FornecedorDAO();
                try {
                    dao.salvar(fornecedor);
                    JOptionPane.showMessageDialog(null, Mensagem.fornecedorAlteradoSucesso);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.fornecedorAlteradoErro);
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarFornecedores();

            }
        }
    }
      public void alterarFornecedor() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFornecedor.getTabelaFornecedor().getModel();
        if (this.viewFornecedor.getTabelaFornecedor().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.fornecedorNaoSelecionado);
        } else {
            fornecedor = listaFornecedores.get(this.viewFornecedor.getTabelaFornecedor().getSelectedRow());
            this.viewFornecedor.getJtfCnpj().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getCnpj());
            this.viewFornecedor.getJtfInscricaoEstadual().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
            this.viewFornecedor.getJtfRazaoSocial().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
            this.viewFornecedor.getJtfDataFundacao().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
            this.viewFornecedor.getJtfEndereco().setText(fornecedor.getEnderecoIdEndereco().getLogradouro());
            this.viewFornecedor.getJtfNumero().setText(fornecedor.getEnderecoIdEndereco().getNumero() + "");
            this.viewFornecedor.getJtfComplemento().setText(fornecedor.getEnderecoIdEndereco().getComplemento());
            this.viewFornecedor.getJtfBairro().setText(fornecedor.getEnderecoIdEndereco().getBairro());
            this.viewFornecedor.getJcbCidade().setSelectedItem(fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            this.viewFornecedor.getJtfCep().setText(fornecedor.getEnderecoIdEndereco().getCep());
            this.viewFornecedor.getJcbEstado().setSelectedItem(fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome() + " - " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
            this.viewFornecedor.getJtfTelefone().setText(fornecedor.getContatoIdContato().getTelefone());
            this.viewFornecedor.getJtfCelular().setText(fornecedor.getContatoIdContato().getCelular());
            this.viewFornecedor.getJtfEmail().setText(fornecedor.getContatoIdContato().getEmail());
            this.viewFornecedor.getJtfContato().setText(fornecedor.getContato());
            this.alterar = true;
            acaoBotaoAlterar();
        }
    }
    public void excluirFornecedor() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFornecedor.getTabelaFornecedor().getModel();
        if (this.viewFornecedor.getTabelaFornecedor().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.fornecedorNaoSelecionado);
        } else {
            fornecedor = listaFornecedores.get(this.viewFornecedor.getTabelaFornecedor().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExclusao, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                FornecedorDAO dao = new FornecedorDAO();
                try {
                    dao.excluir(fornecedor);
                    new ContatoController().excluirContato(fornecedor.getContatoIdContato());
                    new EnderecoController().excluirEndereco(fornecedor.getEnderecoIdEndereco());
                    new PessoaJuridicaController().excluirPessoaJuridica(fornecedor.getPessoaJuridicaIdPessoaJuridica());
                    JOptionPane.showMessageDialog(null, Mensagem.fornecedorExcluidoSucesso);
                    listarFornecedores();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.fornecedorExcluidoErro);
                    Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void excluirFornecedor(Object objeto) {
        try {
            new FornecedorDAO().excluir(objeto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, Mensagem.fornecedorExcluidoErro);
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    Metodos responsaveis por listar, buscar e carregar tabela
    public void listarFornecedores() {
        try {
            FornecedorDAO dao = new FornecedorDAO();
            listaFornecedores = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFornecedor.getTabelaFornecedor().getModel();
        modelo.setRowCount(0);
        for (Fornecedor fornecedor : listaFornecedores) {
            modelo.addRow(new String[]{fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(), fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getNome(), fornecedor.getContatoIdContato().getTelefone(), fornecedor.getContatoIdContato().getCelular()});
        }
    }
     public ArrayList<Fornecedor> buscarTodos() throws Exception {
        FornecedorDAO dao = new FornecedorDAO();
        ArrayList<Fornecedor> lista = dao.buscarTodos();
        return lista;
    }
// metodos responsavel por popular as combos 
    public void carregarComboCidade() {
        CidadeController controller = new CidadeController();
        try {
            listaCidades = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewFornecedor.getJcbCidade().removeAllItems();
        this.viewFornecedor.getJcbCidade().addItem(Mensagem.defaultComboCidade);
        for (Cidade cidade : listaCidades) {
            this.viewFornecedor.getJcbCidade().addItem(cidade.getNome());
        }
    }

    public void carregarComboEstado() {
        EstadoController controller = new EstadoController();
        try {
            listaEstados = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewFornecedor.getJcbEstado().removeAllItems();
        this.viewFornecedor.getJcbEstado().addItem(Mensagem.defaultComboEstado);
        for (Estado estados : listaEstados) {
            this.viewFornecedor.getJcbEstado().addItem(estados.getNome() + " - " + estados.getUf());
        }
    }
// metodos responsavel por colocar ação na tela 
    public void bloqueioInicial() {
        this.viewFornecedor.getJbtNovo().setEnabled(true);
        this.viewFornecedor.getJbtAlterar().setEnabled(true);
        this.viewFornecedor.getJbtExcluir().setEnabled(true);
        this.viewFornecedor.getJbtSair().setEnabled(true);
        this.viewFornecedor.getJbtSalvar().setEnabled(false);
        this.viewFornecedor.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewFornecedor.getJtfPesquisaRazaoSocial().setEditable(true);
        this.viewFornecedor.getJtfPesquisaCNPJ().setEditable(true);
        this.viewFornecedor.getJtfPesquisaRazaoSocial().grabFocus();
        this.viewFornecedor.getJtfCnpj().setEditable(false);
        this.viewFornecedor.getJtfInscricaoEstadual().setEditable(false);
        this.viewFornecedor.getJtfRazaoSocial().setEditable(false);
        this.viewFornecedor.getJtfEndereco().setEditable(false);
        this.viewFornecedor.getJtfNumero().setEditable(false);
        this.viewFornecedor.getJtfComplemento().setEditable(false);
        this.viewFornecedor.getJtfBairro().setEditable(false);
        this.viewFornecedor.getJtfCep().setEditable(false);
        this.viewFornecedor.getJcbCidade().setEnabled(false);
        this.viewFornecedor.getJcbEstado().setEnabled(false);
        this.viewFornecedor.getJtfTelefone().setEditable(false);
        this.viewFornecedor.getJtfCelular().setEditable(false);
        this.viewFornecedor.getJtfDataFundacao().setEditable(false);
        this.viewFornecedor.getJtfEmail().setEditable(false);
        this.viewFornecedor.getJtfContato().setEditable(false);
    }

    public void liberarCampos() {
        this.viewFornecedor.getJtfPesquisaRazaoSocial().setEditable(false);
        this.viewFornecedor.getJtfPesquisaCNPJ().setEditable(false);
        this.viewFornecedor.getJtfCnpj().grabFocus();
        this.viewFornecedor.getJtfCnpj().setEditable(true);
        this.viewFornecedor.getJtfInscricaoEstadual().setEditable(true);
        this.viewFornecedor.getJtfRazaoSocial().setEditable(true);
        this.viewFornecedor.getJtfEndereco().setEditable(true);
        this.viewFornecedor.getJtfNumero().setEditable(true);
        this.viewFornecedor.getJtfComplemento().setEditable(true);
        this.viewFornecedor.getJtfBairro().setEditable(true);
        this.viewFornecedor.getJtfCep().setEditable(true);
        this.viewFornecedor.getJcbCidade().setEnabled(true);
        this.viewFornecedor.getJcbEstado().setEnabled(true);
        this.viewFornecedor.getJtfTelefone().setEditable(true);
        this.viewFornecedor.getJtfCelular().setEditable(true);
        this.viewFornecedor.getJtfDataFundacao().setEditable(true);
        this.viewFornecedor.getJtfEmail().setEditable(true);
        this.viewFornecedor.getJtfContato().setEditable(true);
    }

    public void limparCampos() {
        this.viewFornecedor.getJtfCnpj().setText(null);
        this.viewFornecedor.getJtfCnpj().setValue(null);
        this.viewFornecedor.getJtfInscricaoEstadual().setText(null);
        this.viewFornecedor.getJtfInscricaoEstadual().setValue(null);
        this.viewFornecedor.getJtfDataFundacao().setText(null);
        this.viewFornecedor.getJtfDataFundacao().setValue(null);
        this.viewFornecedor.getJtfRazaoSocial().setText(null);
        this.viewFornecedor.getJtfEndereco().setText(null);
        this.viewFornecedor.getJtfNumero().setText(null);
        this.viewFornecedor.getJtfComplemento().setText(null);
        this.viewFornecedor.getJtfBairro().setText(null);
        this.viewFornecedor.getJcbCidade().setSelectedIndex(0);
        this.viewFornecedor.getJtfCep().setText(null);
        this.viewFornecedor.getJtfCep().setValue(null);
        this.viewFornecedor.getJcbEstado().setSelectedIndex(0);
        this.viewFornecedor.getJtfTelefone().setText(null);
        this.viewFornecedor.getJtfCelular().setText(null);
        this.viewFornecedor.getJtfEmail().setText(null);
        this.viewFornecedor.getJtfContato().setText(null);
    }

    public void acaoBotaoCancelar() {
        this.viewFornecedor.getJtfPesquisaRazaoSocial().setEditable(true);
        this.viewFornecedor.getJtfPesquisaCNPJ().setEditable(true);
        this.viewFornecedor.getJtfPesquisaRazaoSocial().grabFocus();
        this.viewFornecedor.getJbtNovo().setEnabled(true);
        this.viewFornecedor.getJbtAlterar().setEnabled(true);
        this.viewFornecedor.getJbtExcluir().setEnabled(true);
        this.viewFornecedor.getJbtSair().setEnabled(true);
        this.viewFornecedor.getJbtSalvar().setEnabled(false);
        this.viewFornecedor.getJbtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void acaoBotaoNovo() {
        this.viewFornecedor.getJbtNovo().setEnabled(false);
        this.viewFornecedor.getJbtAlterar().setEnabled(false);
        this.viewFornecedor.getJbtExcluir().setEnabled(false);
        this.viewFornecedor.getJtfPesquisaRazaoSocial().setEditable(false);
        this.viewFornecedor.getJtfPesquisaCNPJ().setEditable(false);
        this.viewFornecedor.getJbtSair().setEnabled(false);
        this.viewFornecedor.getJbtSalvar().setEnabled(true);
        this.viewFornecedor.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }
// metodo responsavel por fazer as validações necessarias
    public boolean validarSalvar() {
        if (Valida.verificarVazio(this.viewFornecedor.getJtfCnpj().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.cnpjVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfCnpj().setValue(null);
            this.viewFornecedor.getJtfCnpj().grabFocus();
            return false;
        } else if (!Valida.validarCnpj(this.viewFornecedor.getJtfCnpj().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.cnpjInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfCnpj().setValue(null);
            this.viewFornecedor.getJtfCnpj().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFornecedor.getJtfInscricaoEstadual().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.ieVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfInscricaoEstadual().setValue(null);
            this.viewFornecedor.getJtfInscricaoEstadual().grabFocus();
            return false;
        } else if (!Valida.validarInscricaoEstadual(this.viewFornecedor.getJtfInscricaoEstadual().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.ieInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);;
            this.viewFornecedor.getJtfInscricaoEstadual().setValue(null);
            this.viewFornecedor.getJtfInscricaoEstadual().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFornecedor.getJtfDataFundacao().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.dataFundacaoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfDataFundacao().setValue(null);
            this.viewFornecedor.getJtfDataFundacao().grabFocus();
            return false;
        } else if (!Valida.validarData(this.viewFornecedor.getJtfDataFundacao().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.dataFundacaoInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfDataFundacao().setValue(null);
            this.viewFornecedor.getJtfDataFundacao().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFornecedor.getJtfRazaoSocial().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfRazaoSocial().grabFocus();
            return false;
        } else if (Valida.validarNome(this.viewFornecedor.getJtfRazaoSocial().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.nomeInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfRazaoSocial().setText("");
            this.viewFornecedor.getJtfRazaoSocial().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFornecedor.getJtfEndereco().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.enderecoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfEndereco().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFornecedor.getJtfNumero().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfNumero().grabFocus();
            return false;
        } else if (!Valida.validarNumero(this.viewFornecedor.getJtfNumero().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfNumero().setText("");
            this.viewFornecedor.getJtfNumero().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFornecedor.getJtfBairro().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfBairro().grabFocus();
            return false;
        } else if (Valida.verificarCombo(this.viewFornecedor.getJcbCidade().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJcbCidade().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFornecedor.getJtfCep().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJtfCep().setValue(null);
            this.viewFornecedor.getJtfCep().grabFocus();
            return false;
        } else if (Valida.verificarCombo(this.viewFornecedor.getJcbEstado().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFornecedor.getJcbEstado().grabFocus();
            return false;
        } else if (!Valida.verificarVazio(this.viewFornecedor.getJtfEmail().getText())) {
            if (!Valida.validarEmail(this.viewFornecedor.getJtfEmail().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.emailInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewFornecedor.getJtfEmail().setText("");
                this.viewFornecedor.getJtfEmail().grabFocus();
                return false;
            }
        }
        return true;
    }

   

    public void acaoBotaoAlterar() {
        this.viewFornecedor.getJbtNovo().setEnabled(false);
        this.viewFornecedor.getJbtAlterar().setEnabled(false);
        this.viewFornecedor.getJbtExcluir().setEnabled(false);
        this.viewFornecedor.getJbtSair().setEnabled(false);
        this.viewFornecedor.getJbtSalvar().setEnabled(true);
        this.viewFornecedor.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewFornecedor.getJtfCnpj().setEditable(false);
        this.viewFornecedor.getJtfInscricaoEstadual().setEditable(false);
        this.viewFornecedor.getJtfRazaoSocial().setEditable(false);
        this.viewFornecedor.getJtfDataFundacao().setEditable(false);
    }

   

   
}
