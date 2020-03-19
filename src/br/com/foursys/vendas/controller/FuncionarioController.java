package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.FuncionarioDAO;
import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.model.Endereco;
import br.com.foursys.vendas.model.Estado;
import br.com.foursys.vendas.model.PessoaFisica;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.FuncionarioPrincipal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por controlar todo o processamento de dados relacionados à
 * tela e tabela de funcionários do sistema de vendas
 *
 * @author pbido
 *
 */
public class FuncionarioController {

    private FuncionarioPrincipal viewFuncionario;
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> listaFuncionarios;
    private List<Cidade> listaCidades;
    private List<Estado> listaEstados;
    private boolean alterar;

    public FuncionarioController() {

    }

    public FuncionarioController(FuncionarioPrincipal viewFuncionario) {
        this.viewFuncionario = viewFuncionario;
    }
// metodos responsaveis por salvar ,alterar e excluir funcionarios

    public void salvarFuncionario() {
        if (this.alterar == false) {
            if (validarSalvar()) {
                Funcionario funcionario = new Funcionario();
                PessoaFisica pessoaFisica = new PessoaFisica();
                Endereco endereco = new Endereco();
                Cidade cidade;
                Contato contato = new Contato();
                pessoaFisica.setNome(this.viewFuncionario.getJtfNome().getText());
                pessoaFisica.setCpf(this.viewFuncionario.getJtfCpf().getText());
                pessoaFisica.setRg(this.viewFuncionario.getJtfRg().getText());
                pessoaFisica.setDataNascimento(this.viewFuncionario.getJtfDataNascimento().getText());
                funcionario.setPessoaFisicaIdPessoaFisica(pessoaFisica);
                new PessoaFisicaController().salvarPessoaFisica(pessoaFisica);
                endereco.setLogradouro(this.viewFuncionario.getJtfEndereco().getText());
                endereco.setNumero(Integer.parseInt(this.viewFuncionario.getJtfNumero().getText()));
                endereco.setComplemento(this.viewFuncionario.getJtfComplemento().getText());
                endereco.setBairro(this.viewFuncionario.getJtfBairro().getText());
                endereco.setCep(this.viewFuncionario.getJtfCep().getText());
                cidade = listaCidades.get(this.viewFuncionario.getJcbCidade().getSelectedIndex() - 1);
                endereco.setCidadeIdCidade(cidade);
                funcionario.setEnderecoIdEndereco(endereco);
                new EnderecoController().salvarEndereco(endereco);
                contato.setTelefone(this.viewFuncionario.getJtfTelefone().getText());
                contato.setCelular(this.viewFuncionario.getJtfCelular().getText());
                contato.setEmail(this.viewFuncionario.getJtfEmail().getText());
                funcionario.setContatoIdContato(contato);
                funcionario.setLogin(this.viewFuncionario.getJtfLogin().getText());
                funcionario.setSenha(this.viewFuncionario.getJtfSenha().getText());
                new ContatoController().salvarContato(contato);
                FuncionarioDAO dao = new FuncionarioDAO();
                try {
                    dao.salvar(funcionario);
                    JOptionPane.showMessageDialog(null, Mensagem.funcionarioInseridoSucesso);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.funcionarioInseridoErro);
                    Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarFuncionarios();
            }
        } else {
            if (validarSalvar()) {
                funcionario.getPessoaFisicaIdPessoaFisica().setNome(this.viewFuncionario.getJtfNome().getText());
                funcionario.getPessoaFisicaIdPessoaFisica().setCpf(this.viewFuncionario.getJtfCpf().getText());
                funcionario.getPessoaFisicaIdPessoaFisica().setRg(this.viewFuncionario.getJtfRg().getText());
                funcionario.getPessoaFisicaIdPessoaFisica().setDataNascimento(this.viewFuncionario.getJtfDataNascimento().getText());
                new PessoaFisicaController().salvarPessoaFisica(funcionario.getPessoaFisicaIdPessoaFisica());

                funcionario.setSenha(this.viewFuncionario.getJtfSenha().getText());
                funcionario.setLogin(this.viewFuncionario.getJtfLogin().getText());

                funcionario.getEnderecoIdEndereco().setLogradouro(this.viewFuncionario.getJtfEndereco().getText());
                funcionario.getEnderecoIdEndereco().setNumero(Integer.parseInt(this.viewFuncionario.getJtfNumero().getText()));
                funcionario.getEnderecoIdEndereco().setComplemento(this.viewFuncionario.getJtfComplemento().getText());
                funcionario.getEnderecoIdEndereco().setBairro(this.viewFuncionario.getJtfBairro().getText());
                funcionario.getEnderecoIdEndereco().setCep(this.viewFuncionario.getJtfCep().getText());

                Cidade cidade;
                cidade = listaCidades.get(this.viewFuncionario.getJcbCidade().getSelectedIndex() - 1);
                funcionario.getEnderecoIdEndereco().setCidadeIdCidade(cidade);
                new EnderecoController().salvarEndereco(funcionario.getEnderecoIdEndereco());
                funcionario.getContatoIdContato().setTelefone(this.viewFuncionario.getJtfTelefone().getText());
                funcionario.getContatoIdContato().setCelular(this.viewFuncionario.getJtfCelular().getText());
                funcionario.getContatoIdContato().setEmail(this.viewFuncionario.getJtfEmail().getText());
                new ContatoController().salvarContato(funcionario.getContatoIdContato());
                FuncionarioDAO dao = new FuncionarioDAO();
                try {
                    dao.salvar(funcionario);
                    JOptionPane.showMessageDialog(null, Mensagem.funcionarioAlteradoSucesso);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.funcionarioAlteradoErro);
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarFuncionarios();

            }
        }
    }

    public void excluirFuncionario() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFuncionario.getTabelaFuncionario().getModel();
        if (this.viewFuncionario.getTabelaFuncionario().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.funcionarioNaoSelecionado);
        } else {
            funcionario = listaFuncionarios.get(this.viewFuncionario.getTabelaFuncionario().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExclusao, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                FuncionarioDAO dao = new FuncionarioDAO();
                try {
                    dao.excluir(funcionario);
                    new ContatoController().excluirContato(funcionario.getContatoIdContato());
                    new EnderecoController().excluirEndereco(funcionario.getEnderecoIdEndereco());
                    new PessoaFisicaController().excluirPessoaFisica(funcionario.getPessoaFisicaIdPessoaFisica());
                    JOptionPane.showMessageDialog(null, Mensagem.funcionarioExcluidoSucesso);
                    listarFuncionarios();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.funcionarioExcluidoErro);
                    Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void alterarFuncionario() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFuncionario.getTabelaFuncionario().getModel();
        if (this.viewFuncionario.getTabelaFuncionario().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.funcionarioNaoSelecionado);
        } else {
            funcionario = listaFuncionarios.get(this.viewFuncionario.getTabelaFuncionario().getSelectedRow());
            this.viewFuncionario.getJtfLogin().setText(funcionario.getLogin());
            this.viewFuncionario.getJtfSenha().setText(funcionario.getSenha());
            this.viewFuncionario.getJtfCpf().setText(funcionario.getPessoaFisicaIdPessoaFisica().getCpf());
            this.viewFuncionario.getJtfRg().setText(funcionario.getPessoaFisicaIdPessoaFisica().getRg());
            this.viewFuncionario.getJtfNome().setText(funcionario.getPessoaFisicaIdPessoaFisica().getNome());
            this.viewFuncionario.getJtfDataNascimento().setText(funcionario.getPessoaFisicaIdPessoaFisica().getDataNascimento());
            this.viewFuncionario.getJtfEndereco().setText(funcionario.getEnderecoIdEndereco().getLogradouro());
            this.viewFuncionario.getJtfNumero().setText(funcionario.getEnderecoIdEndereco().getNumero() + "");
            this.viewFuncionario.getJtfComplemento().setText(funcionario.getEnderecoIdEndereco().getComplemento());
            this.viewFuncionario.getJtfBairro().setText(funcionario.getEnderecoIdEndereco().getBairro());
            this.viewFuncionario.getJcbCidade().setSelectedItem(funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            this.viewFuncionario.getJtfCep().setText(funcionario.getEnderecoIdEndereco().getCep());
            this.viewFuncionario.getJcbEstado().setSelectedItem(funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome() + " - " + funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
            this.viewFuncionario.getJtfTelefone().setText(funcionario.getContatoIdContato().getTelefone());
            this.viewFuncionario.getJtfCelular().setText(funcionario.getContatoIdContato().getCelular());
            this.viewFuncionario.getJtfEmail().setText(funcionario.getContatoIdContato().getEmail());
            this.alterar = true;
            acaoBotaoAlterar();
        }
    }
//    Metodos responsaveis por listar, buscar e carregar tabela
    public void listarFuncionarios() {
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            listaFuncionarios = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewFuncionario.getTabelaFuncionario().getModel();
        modelo.setRowCount(0);
        for (Funcionario funcionario : listaFuncionarios) {
            modelo.addRow(new String[]{funcionario.getPessoaFisicaIdPessoaFisica().getNome(), funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getNome(), funcionario.getContatoIdContato().getTelefone(), funcionario.getContatoIdContato().getCelular()});
        }
    }

    public List<Funcionario> buscarTodos(String login) {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> listaFuncionario = null;
        try {
            listaFuncionario = dao.buscarTodos(login);
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFuncionario;
    }

    public List<Funcionario> buscarTodos() {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> listaFuncionario = null;
        try {
            listaFuncionario = dao.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFuncionario;
    }
// metodos responsavel por popular as combos
    public void carregarComboCidade() {
        CidadeController controller = new CidadeController();
        try {
            listaCidades = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewFuncionario.getJcbCidade().removeAllItems();
        this.viewFuncionario.getJcbCidade().addItem(Mensagem.defaultComboCidade);
        for (Cidade cidade : listaCidades) {
            this.viewFuncionario.getJcbCidade().addItem(cidade.getNome());
        }
    }

    public void carregarComboEstado() {
        EstadoController controller = new EstadoController();
        try {
            listaEstados = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewFuncionario.getJcbEstado().removeAllItems();
        this.viewFuncionario.getJcbEstado().addItem(Mensagem.defaultComboEstado);
        for (Estado estados : listaEstados) {
            this.viewFuncionario.getJcbEstado().addItem(estados.getNome() + " - " + estados.getUf());
        }
    }
// metodos responsavel por colocar ação na tela 
    public void bloqueioInicial() {
        this.viewFuncionario.getJbtNovo().setEnabled(true);
        this.viewFuncionario.getJbtAlterar().setEnabled(true);
        this.viewFuncionario.getJbtExcluir().setEnabled(true);
        this.viewFuncionario.getJbtSair().setEnabled(true);
        this.viewFuncionario.getJbtSalvar().setEnabled(false);
        this.viewFuncionario.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewFuncionario.getJtfPesquisarNome().setEditable(true);
        this.viewFuncionario.getJtfPesquisarNome().grabFocus();
        this.viewFuncionario.getJtfCpf().setEditable(false);
        this.viewFuncionario.getJtfRg().setEditable(false);
        this.viewFuncionario.getJtfNome().setEditable(false);
        this.viewFuncionario.getJtfEndereco().setEditable(false);
        this.viewFuncionario.getJtfNumero().setEditable(false);
        this.viewFuncionario.getJtfComplemento().setEditable(false);
        this.viewFuncionario.getJtfBairro().setEditable(false);
        this.viewFuncionario.getJtfCep().setEditable(false);
        this.viewFuncionario.getJcbCidade().setEnabled(false);
        this.viewFuncionario.getJcbEstado().setEnabled(false);
        this.viewFuncionario.getJtfTelefone().setEditable(false);
        this.viewFuncionario.getJtfCelular().setEditable(false);
        this.viewFuncionario.getJtfDataNascimento().setEditable(false);
        this.viewFuncionario.getJtfEmail().setEditable(false);
        this.viewFuncionario.getJtfLogin().setEditable(false);
        this.viewFuncionario.getJtfSenha().setEditable(false);
    }

    public void liberarCampos() {
        this.viewFuncionario.getJtfPesquisarNome().setEditable(false);
        this.viewFuncionario.getJtfCpf().grabFocus();
        this.viewFuncionario.getJtfCpf().setEditable(true);
        this.viewFuncionario.getJtfRg().setEditable(true);
        this.viewFuncionario.getJtfNome().setEditable(true);
        this.viewFuncionario.getJtfEndereco().setEditable(true);
        this.viewFuncionario.getJtfNumero().setEditable(true);
        this.viewFuncionario.getJtfComplemento().setEditable(true);
        this.viewFuncionario.getJtfBairro().setEditable(true);
        this.viewFuncionario.getJtfCep().setEditable(true);
        this.viewFuncionario.getJcbCidade().setEnabled(true);
        this.viewFuncionario.getJcbEstado().setEnabled(true);
        this.viewFuncionario.getJtfTelefone().setEditable(true);
        this.viewFuncionario.getJtfCelular().setEditable(true);
        this.viewFuncionario.getJtfLogin().setEditable(true);
        this.viewFuncionario.getJtfSenha().setEditable(true);
        this.viewFuncionario.getJtfDataNascimento().setEditable(true);
        this.viewFuncionario.getJtfEmail().setEditable(true);
    }

    public void limparCampos() {
        this.viewFuncionario.getJtfCpf().setText(null);
        this.viewFuncionario.getJtfCpf().setValue(null);
        this.viewFuncionario.getJtfRg().setText(null);
        this.viewFuncionario.getJtfRg().setValue(null);
        this.viewFuncionario.getJtfDataNascimento().setText(null);
        this.viewFuncionario.getJtfDataNascimento().setValue(null);
        this.viewFuncionario.getJtfNome().setText(null);
        this.viewFuncionario.getJtfEndereco().setText(null);
        this.viewFuncionario.getJtfNumero().setText(null);
        this.viewFuncionario.getJtfComplemento().setText(null);
        this.viewFuncionario.getJtfBairro().setText(null);
        this.viewFuncionario.getJcbCidade().setSelectedIndex(0);
        this.viewFuncionario.getJtfCep().setText(null);
        this.viewFuncionario.getJtfCep().setValue(null);
        this.viewFuncionario.getJcbEstado().setSelectedIndex(0);
        this.viewFuncionario.getJtfTelefone().setText(null);
        this.viewFuncionario.getJtfCelular().setText(null);
        this.viewFuncionario.getJtfEmail().setText(null);
        this.viewFuncionario.getJtfLogin().setText(null);
        this.viewFuncionario.getJtfSenha().setText(null);
    }

    public void acaoBotaoCancelar() {
        this.viewFuncionario.getJbtPesquisarFuncionario().setEnabled(true);
        this.viewFuncionario.getJbtPesquisarFuncionario().grabFocus();
        this.viewFuncionario.getJbtNovo().setEnabled(true);
        this.viewFuncionario.getJbtAlterar().setEnabled(true);
        this.viewFuncionario.getJbtExcluir().setEnabled(true);
        this.viewFuncionario.getJbtSair().setEnabled(true);
        this.viewFuncionario.getJbtSalvar().setEnabled(false);
        this.viewFuncionario.getJbtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void acaoBotaoNovo() {
        this.viewFuncionario.getJbtNovo().setEnabled(false);
        this.viewFuncionario.getJbtAlterar().setEnabled(false);
        this.viewFuncionario.getJbtExcluir().setEnabled(false);
        this.viewFuncionario.getJbtPesquisarFuncionario().setEnabled(false);
        this.viewFuncionario.getJbtSair().setEnabled(false);
        this.viewFuncionario.getJbtSalvar().setEnabled(true);
        this.viewFuncionario.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }
       public void acaoBotaoAlterar() {
        this.viewFuncionario.getJbtNovo().setEnabled(false);
        this.viewFuncionario.getJbtAlterar().setEnabled(false);
        this.viewFuncionario.getJbtExcluir().setEnabled(false);
        this.viewFuncionario.getJbtSair().setEnabled(false);
        this.viewFuncionario.getJbtSalvar().setEnabled(true);
        this.viewFuncionario.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewFuncionario.getJtfCpf().setEditable(false);
        this.viewFuncionario.getJtfRg().setEditable(false);
        this.viewFuncionario.getJtfNome().setEditable(false);
        this.viewFuncionario.getJtfDataNascimento().setEditable(false);
    }
// metodo responsavel por fazer as validações necessarias 
    public boolean validarSalvar() {
        if (Valida.verificarVazio(this.viewFuncionario.getJtfCpf().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfCpf().setValue(null);
            this.viewFuncionario.getJtfCpf().grabFocus();
            return false;
        } else if (!Valida.validarCpf(this.viewFuncionario.getJtfCpf().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.cpfInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfCpf().setValue(null);
            this.viewFuncionario.getJtfCpf().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFuncionario.getJtfRg().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfRg().setValue(null);
            this.viewFuncionario.getJtfRg().grabFocus();
            return false;
        } else if (Valida.validarRg(this.viewFuncionario.getJtfRg().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.rgInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);;
            this.viewFuncionario.getJtfRg().setValue(null);
            this.viewFuncionario.getJtfRg().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFuncionario.getJtfDataNascimento().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.dataNascimentoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfDataNascimento().setValue(null);
            this.viewFuncionario.getJtfDataNascimento().grabFocus();
            return false;
        } else if (!Valida.validarData(this.viewFuncionario.getJtfDataNascimento().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.dataNascimentoInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfDataNascimento().setValue(null);
            this.viewFuncionario.getJtfDataNascimento().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFuncionario.getJtfNome().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfNome().grabFocus();
            return false;
        } else if (Valida.validarNome(this.viewFuncionario.getJtfNome().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.nomeInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfNome().setText("");
            this.viewFuncionario.getJtfNome().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFuncionario.getJtfEndereco().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.enderecoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfEndereco().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFuncionario.getJtfNumero().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfNumero().grabFocus();
            return false;
        } else if (!Valida.validarNumero(this.viewFuncionario.getJtfNumero().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfNumero().setText("");
            this.viewFuncionario.getJtfNumero().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFuncionario.getJtfBairro().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfBairro().grabFocus();
            return false;
        } else if (Valida.verificarCombo(this.viewFuncionario.getJcbCidade().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJcbCidade().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFuncionario.getJtfCep().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfCep().setValue(null);
            this.viewFuncionario.getJtfCep().grabFocus();
            return false;
        } else if (Valida.verificarCombo(this.viewFuncionario.getJcbEstado().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJcbEstado().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFuncionario.getJtfLogin().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.loginVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfLogin().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewFuncionario.getJtfSenha().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.senhaVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewFuncionario.getJtfSenha().grabFocus();
            return false;
        } else if (!Valida.verificarVazio(this.viewFuncionario.getJtfEmail().getText())) {
            if (!Valida.validarEmail(this.viewFuncionario.getJtfEmail().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.emailInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewFuncionario.getJtfEmail().setText("");
                this.viewFuncionario.getJtfEmail().grabFocus();
                return false;
            }
        }
        return true;
    }

 

    
}
