package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ClienteDAO;
import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.model.Cliente;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.model.Endereco;
import br.com.foursys.vendas.model.Estado;
import br.com.foursys.vendas.model.PessoaFisica;
import br.com.foursys.vendas.model.PessoaJuridica;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.util.Valida;
import br.com.foursys.vendas.view.ClientePrincipal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * Classe responsável por controlar todo o processamento de dados relacionados à
 * tela de cadastro de cliente e a tabela de cliente
 *
 * @author pbido
 * @since 10/03/2020
 * @version 0.1
 */
public class ClienteController {

    private ClientePrincipal viewCliente;
    private Cliente cliente = new Cliente();
    private List<Cliente> listaClientes;
    private List<Cidade> listaCidades;
    private List<Estado> listaEstados;
    private boolean alterar;

    public ClienteController() {

    }

    public ClienteController(ClientePrincipal viewCliente) {
        this.viewCliente = viewCliente;
    }
// metodos responsaveis por salvar ,alterar e excluir cliente

    public void salvarCliente() {
        if (this.alterar == false) {
            if (validarSalvar()) {
                Cliente cliente = new Cliente();
                PessoaFisica pessoaFisica = new PessoaFisica();
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                Endereco endereco = new Endereco();
                Cidade cidade = new Cidade();
                Contato contato = new Contato();

                if (this.viewCliente.getJrbFisico().isSelected()) {
                    pessoaFisica.setNome(this.viewCliente.getJtfNome().getText());
                    pessoaFisica.setCpf(this.viewCliente.getJtfCpf().getText());
                    pessoaFisica.setRg(this.viewCliente.getJtfRg().getText());
                    pessoaFisica.setDataNascimento(this.viewCliente.getJtfDataNascimento().getText());
                    cliente.setTipoPessoa("F");
                    cliente.setPessoaFisicaIdPessoaFisica(pessoaFisica);
                    new PessoaFisicaController().salvarPessoaFisica(pessoaFisica);
                } else {
                    pessoaJuridica.setRazaoSocial(this.viewCliente.getJtfNome().getText());
                    pessoaJuridica.setCnpj(this.viewCliente.getJtfCpf().getText());
                    pessoaJuridica.setInscricaoEstadual(this.viewCliente.getJtfRg().getText());
                    pessoaJuridica.setDataFundacao(this.viewCliente.getJtfDataNascimento().getText());
                    cliente.setTipoPessoa("J");
                    cliente.setPessoaJuridicaIdPessoaJuridica(pessoaJuridica);
                    new PessoaJuridicaController().salvarPessoaJuridica(pessoaJuridica);
                }
                endereco.setLogradouro(this.viewCliente.getJtfEndereco().getText());
                endereco.setNumero(Integer.parseInt(this.viewCliente.getJtfNumero().getText()));
                endereco.setComplemento(this.viewCliente.getJtfComplemento().getText());
                endereco.setBairro(this.viewCliente.getJtfBairro().getText());
                endereco.setCep(this.viewCliente.getJtfCep().getText());

                cidade = listaCidades.get(this.viewCliente.getJcbCidade().getSelectedIndex() - 1);
                endereco.setCidadeIdCidade(cidade);
                cliente.setEnderecoIdEndereco(endereco);
                new EnderecoController().salvarEndereco(endereco);
                contato.setTelefone(this.viewCliente.getJtfTelefone().getText());
                contato.setEmail(this.viewCliente.getJtfEmail().getText());
                contato.setCelular(this.viewCliente.getJtfCelular().getText());
                cliente.setContatoIdContato(contato);
                new ContatoController().salvarContato(contato);
                ClienteDAO dao = new ClienteDAO();
                try {
                    dao.salvar(cliente);
                    JOptionPane.showMessageDialog(null, Mensagem.clienteInseridoSucesso);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.clienteInseridoErro);
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarClientes();
            }
        } else {
            if (validarSalvar()) {
                if (this.viewCliente.getJrbFisico().isSelected()) {
                    cliente.getPessoaFisicaIdPessoaFisica().setNome(this.viewCliente.getJtfNome().getText());
                    cliente.getPessoaFisicaIdPessoaFisica().setCpf(this.viewCliente.getJtfCpf().getText());
                    cliente.getPessoaFisicaIdPessoaFisica().setRg(this.viewCliente.getJtfRg().getText());
                    cliente.getPessoaFisicaIdPessoaFisica().setDataNascimento(this.viewCliente.getJtfDataNascimento().getText());
                    cliente.setTipoPessoa("F");
                    new PessoaFisicaController().salvarPessoaFisica(cliente.getPessoaFisicaIdPessoaFisica());
                } else {
                    cliente.getPessoaJuridicaIdPessoaJuridica().setRazaoSocial(this.viewCliente.getJtfNome().getText());
                    cliente.getPessoaJuridicaIdPessoaJuridica().setCnpj(this.viewCliente.getJtfCpf().getText());
                    cliente.getPessoaJuridicaIdPessoaJuridica().setInscricaoEstadual(this.viewCliente.getJtfRg().getText());
                    cliente.getPessoaJuridicaIdPessoaJuridica().setDataFundacao(this.viewCliente.getJtfDataNascimento().getText());
                    cliente.setTipoPessoa("J");
                    new PessoaJuridicaController().salvarPessoaJuridica(cliente.getPessoaJuridicaIdPessoaJuridica());
                }
                cliente.getEnderecoIdEndereco().setLogradouro(this.viewCliente.getJtfEndereco().getText());
                cliente.getEnderecoIdEndereco().setNumero(Integer.parseInt(this.viewCliente.getJtfNumero().getText()));
                cliente.getEnderecoIdEndereco().setComplemento(this.viewCliente.getJtfComplemento().getText());
                cliente.getEnderecoIdEndereco().setBairro(this.viewCliente.getJtfBairro().getText());
                cliente.getEnderecoIdEndereco().setCep(this.viewCliente.getJtfCep().getText());

                Cidade cidade = new Cidade();
                cidade = listaCidades.get(this.viewCliente.getJcbCidade().getSelectedIndex() - 1);
                cliente.getEnderecoIdEndereco().setCidadeIdCidade(cidade);
                new EnderecoController().salvarEndereco(cliente.getEnderecoIdEndereco());
                cliente.getContatoIdContato().setTelefone(this.viewCliente.getJtfTelefone().getText());
                cliente.getContatoIdContato().setEmail(this.viewCliente.getJtfEmail().getText());
                cliente.getContatoIdContato().setCelular(this.viewCliente.getJtfCelular().getText());
                new ContatoController().salvarContato(cliente.getContatoIdContato());
                ClienteDAO dao = new ClienteDAO();
                try {
                    dao.salvar(cliente);
                    JOptionPane.showMessageDialog(null, Mensagem.clienteAlteradoSucesso);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.clienteAlteradoErro);
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarClientes();
            }
        }
    }

    public void alterarCliente() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCliente.getTabelaCliente().getModel();
        if (this.viewCliente.getTabelaCliente().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.clienteNaoSelecionado);
        } else {
            cliente = listaClientes.get(this.viewCliente.getTabelaCliente().getSelectedRow());
            if (cliente.getTipoPessoa().equals("F")) {
                this.viewCliente.getJrbFisico().setSelected(true);
                this.viewCliente.getJtfCpf().setText(cliente.getPessoaFisicaIdPessoaFisica().getCpf());
                this.viewCliente.getJtfRg().setText(cliente.getPessoaFisicaIdPessoaFisica().getRg());
                this.viewCliente.getJtfNome().setText(cliente.getPessoaFisicaIdPessoaFisica().getNome());
                this.viewCliente.getJtfDataNascimento().setText(cliente.getPessoaFisicaIdPessoaFisica().getDataNascimento());
            } else {
                this.viewCliente.getJrbJuridico().setSelected(true);
                this.viewCliente.getJtfCpf().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getCnpj());
                this.viewCliente.getJtfRg().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
                this.viewCliente.getJtfNome().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
                this.viewCliente.getJtfDataNascimento().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
            }
            this.viewCliente.getJtfEndereco().setText(cliente.getEnderecoIdEndereco().getLogradouro());
            this.viewCliente.getJtfNumero().setText(cliente.getEnderecoIdEndereco().getNumero() + "");
            this.viewCliente.getJtfComplemento().setText(cliente.getEnderecoIdEndereco().getComplemento());
            this.viewCliente.getJtfBairro().setText(cliente.getEnderecoIdEndereco().getBairro());
            this.viewCliente.getJcbCidade().setSelectedItem(cliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            this.viewCliente.getJtfCep().setText(cliente.getEnderecoIdEndereco().getCep());
            this.viewCliente.getJcbEstado().setSelectedItem(cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome() + " - " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
            this.viewCliente.getJtfTelefone().setText(cliente.getContatoIdContato().getTelefone());
            this.viewCliente.getJtfCelular().setText(cliente.getContatoIdContato().getCelular());
            this.viewCliente.getJtfEmail().setText(cliente.getContatoIdContato().getEmail());
            this.alterar = true;
            acaoBotaoAlterar();
        }
    }

    public void excluirCliente() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCliente.getTabelaCliente().getModel();
        if (this.viewCliente.getTabelaCliente().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, Mensagem.clienteNaoSelecionado);
        } else {
            cliente = listaClientes.get(this.viewCliente.getTabelaCliente().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, Mensagem.confirmaExclusao, Mensagem.atencao,
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                ClienteDAO dao = new ClienteDAO();
                try {
                    dao.excluir(cliente);
                    new ContatoController().excluirContato(cliente.getContatoIdContato());
                    new EnderecoController().excluirEndereco(cliente.getEnderecoIdEndereco());
                    if (cliente.getTipoPessoa().equals("F")) {
                        new PessoaFisicaController().excluirPessoaFisica(cliente.getPessoaFisicaIdPessoaFisica());
                    } else {
                        new PessoaJuridicaController().excluirPessoaJuridica(cliente.getPessoaJuridicaIdPessoaJuridica());
                    }
                    JOptionPane.showMessageDialog(null, Mensagem.clienteExcluidoSucesso);
                    listarClientes();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, Mensagem.clienteExcluidoErro);
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
//    Metodos responsaveis por listar, buscar e carregar tabela

    public List<Cliente> buscarTodos() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> listaFuncionario = null;
        try {
            listaFuncionario = dao.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFuncionario;
    }

    public void listarClientes() {
        try {
            ClienteDAO dao = new ClienteDAO();
            listaClientes = dao.buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewCliente.getTabelaCliente().getModel();
        modelo.setRowCount(0);
        for (Cliente cliente : listaClientes) {
            if (cliente.getTipoPessoa().equals("F")) {
                modelo.addRow(new String[]{cliente.getPessoaFisicaIdPessoaFisica().getNome(), cliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome(), cliente.getContatoIdContato().getCelular(), cliente.getContatoIdContato().getEmail()});
            } else {
                modelo.addRow(new String[]{cliente.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(), cliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome(), cliente.getContatoIdContato().getCelular(), cliente.getContatoIdContato().getEmail()});
            }
        }
    }
// metodos responsavel por popular as combos 

    public void carregarComboCidade() {
        CidadeController controller = new CidadeController();
        try {
            listaCidades = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewCliente.getJcbCidade().removeAllItems();
        this.viewCliente.getJcbCidade().addItem(Mensagem.defaultComboCidade);
        for (Cidade cidade : listaCidades) {
            this.viewCliente.getJcbCidade().addItem(cidade.getNome());
        }
    }

    public void carregarComboEstado() {
        EstadoController controller = new EstadoController();
        try {
            listaEstados = controller.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.viewCliente.getJcbEstado().removeAllItems();
        this.viewCliente.getJcbEstado().addItem(Mensagem.defaultComboEstado);
        for (Estado estados : listaEstados) {
            this.viewCliente.getJcbEstado().addItem(estados.getNome() + " - " + estados.getUf());
        }
    }
// metodos responsavel por colocar ação na tela 

    public void bloqueioInicial() {
        this.viewCliente.getJbtNovo().setEnabled(true);
        this.viewCliente.getJbtAlterar().setEnabled(true);
        this.viewCliente.getJbtExcluir().setEnabled(true);
        this.viewCliente.getJbtSair().setEnabled(true);
        this.viewCliente.getJbtSalvar().setEnabled(false);
        this.viewCliente.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewCliente.getJtfPesquisarNome().setEditable(true);
        this.viewCliente.getJtfPesquisarNome().grabFocus();
        this.viewCliente.getJtfCpf().setEditable(false);
        this.viewCliente.getJtfRg().setEditable(false);
        this.viewCliente.getJtfNome().setEditable(false);
        this.viewCliente.getJtfEndereco().setEditable(false);
        this.viewCliente.getJtfNumero().setEditable(false);
        this.viewCliente.getJtfComplemento().setEditable(false);
        this.viewCliente.getJtfBairro().setEditable(false);
        this.viewCliente.getJtfCep().setEditable(false);
        this.viewCliente.getJcbCidade().setEnabled(false);
        this.viewCliente.getJcbEstado().setEnabled(false);
        this.viewCliente.getJtfTelefone().setEditable(false);
        this.viewCliente.getJtfCelular().setEditable(false);
        this.viewCliente.getJtfEmail().setEditable(false);
        this.viewCliente.getJrbFisico().setEnabled(false);
        this.viewCliente.getJrbJuridico().setEnabled(false);
        this.viewCliente.getJtfDataNascimento().setEditable(false);
    }

    public void liberarCampos() {
        this.viewCliente.getJtfPesquisarNome().setEditable(false);
        this.viewCliente.getJtfCpf().grabFocus();
        this.viewCliente.getJtfCpf().setEditable(true);
        this.viewCliente.getJtfRg().setEditable(true);
        this.viewCliente.getJtfNome().setEditable(true);
        this.viewCliente.getJtfEndereco().setEditable(true);
        this.viewCliente.getJtfNumero().setEditable(true);
        this.viewCliente.getJtfComplemento().setEditable(true);
        this.viewCliente.getJtfBairro().setEditable(true);
        this.viewCliente.getJtfCep().setEditable(true);
        this.viewCliente.getJcbCidade().setEnabled(true);
        this.viewCliente.getJcbEstado().setEnabled(true);
        this.viewCliente.getJtfTelefone().setEditable(true);
        this.viewCliente.getJtfCelular().setEditable(true);
        this.viewCliente.getJtfEmail().setEditable(true);
        this.viewCliente.getJrbFisico().setEnabled(true);
        this.viewCliente.getJrbJuridico().setEnabled(true);
        this.viewCliente.getJtfDataNascimento().setEditable(true);
    }

    public void limparCampos() {
        this.viewCliente.getButtonGroup1().clearSelection();
        this.viewCliente.getJtfCpf().setText(null);
        this.viewCliente.getJtfCpf().setValue(null);
        this.viewCliente.getJtfRg().setText(null);
        this.viewCliente.getJtfRg().setValue(null);
        this.viewCliente.getJtfNome().setText(null);
        this.viewCliente.getJtfDataNascimento().setText(null);
        this.viewCliente.getJtfDataNascimento().setValue(null);
        this.viewCliente.getJtfEndereco().setText(null);
        this.viewCliente.getJtfNumero().setText(null);
        this.viewCliente.getJtfComplemento().setText(null);
        this.viewCliente.getJtfBairro().setText(null);
        this.viewCliente.getJcbCidade().setSelectedIndex(0);
        this.viewCliente.getJtfCep().setText(null);
        this.viewCliente.getJtfCep().setValue(null);
        this.viewCliente.getJcbEstado().setSelectedIndex(0);
        this.viewCliente.getJtfTelefone().setText(null);
        this.viewCliente.getJtfCelular().setText(null);
        this.viewCliente.getJtfEmail().setText(null);
    }

    public void acaoBotaoCancelar() {
        this.viewCliente.getJbtNovo().setEnabled(true);
        this.viewCliente.getJbtAlterar().setEnabled(true);
        this.viewCliente.getJbtExcluir().setEnabled(true);
        this.viewCliente.getJbtSair().setEnabled(true);
        this.viewCliente.getJbtSalvar().setEnabled(false);
        this.viewCliente.getJbtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void acaoBotaoNovo() {
        this.viewCliente.getJbtNovo().setEnabled(false);
        this.viewCliente.getJbtAlterar().setEnabled(false);
        this.viewCliente.getJbtExcluir().setEnabled(false);
        this.viewCliente.getJbtSair().setEnabled(false);
        this.viewCliente.getJbtSalvar().setEnabled(true);
        this.viewCliente.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }

    public void acaoBotaoAlterar() {
        this.viewCliente.getJbtNovo().setEnabled(false);
        this.viewCliente.getJbtAlterar().setEnabled(false);
        this.viewCliente.getJbtExcluir().setEnabled(false);
        this.viewCliente.getJbtSair().setEnabled(false);
        this.viewCliente.getJbtSalvar().setEnabled(true);
        this.viewCliente.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewCliente.getJrbFisico().setEnabled(false);
        this.viewCliente.getJrbJuridico().setEnabled(false);
        this.viewCliente.getJtfCpf().setEditable(false);
        this.viewCliente.getJtfRg().setEditable(false);
        this.viewCliente.getJtfNome().setEditable(false);
        this.viewCliente.getJtfDataNascimento().setEditable(false);
    }

    public void selecionaJuridico() {
        this.viewCliente.getJlbCpf().setText("CNPJ:");
        try {
            this.viewCliente.getJtfCpf().setValue(null);
            MaskFormatter cnpj = new MaskFormatter("##.###.###/####-##");
            this.viewCliente.getJtfCpf().setFormatterFactory(
                    new DefaultFormatterFactory(cnpj));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.viewCliente.getJlbRg().setText("IE:");
        try {
            this.viewCliente.getJtfRg().setValue(null);
            MaskFormatter ie = new MaskFormatter("###.###.###.###");
            this.viewCliente.getJtfRg().setFormatterFactory(
                    new DefaultFormatterFactory(ie));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.viewCliente.getJlbNome().setText("Razão Social:");
        this.viewCliente.getJlbDataNascimento().setText("Data da Fundação:");
    }

    public void selecionaFisico() {
        this.viewCliente.getJlbCpf().setText("CPF:");
        try {
            this.viewCliente.getJtfCpf().setValue(null);
            MaskFormatter cpf = new MaskFormatter("###.###.###-##");
            this.viewCliente.getJtfCpf().setFormatterFactory(
                    new DefaultFormatterFactory(cpf));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.viewCliente.getJlbRg().setText("RG:");
        try {
            this.viewCliente.getJtfRg().setValue(null);
            MaskFormatter rg = new MaskFormatter("##.###.###");
            this.viewCliente.getJtfRg().setFormatterFactory(
                    new DefaultFormatterFactory(rg));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.viewCliente.getJlbNome().setText("Nome:");
        this.viewCliente.getJlbDataNascimento().setText("Data de Nascimento:");
    }
// metodo responsavel por fazer as validações necessarias 
    public boolean validarSalvar() {
        if (this.viewCliente.getJrbFisico().isSelected()) {
            if (Valida.verificarVazio(this.viewCliente.getJtfCpf().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfCpf().setValue(null);
                this.viewCliente.getJtfCpf().grabFocus();
                return false;
            } else if (!Valida.validarCpf(this.viewCliente.getJtfCpf().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.cpfInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfCpf().setValue(null);
                this.viewCliente.getJtfCpf().grabFocus();
                return false;
            } else if (Valida.verificarVazio(this.viewCliente.getJtfRg().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfRg().setValue(null);
                this.viewCliente.getJtfRg().grabFocus();
                return false;
            } else if (Valida.validarRg(this.viewCliente.getJtfRg().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.rgInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);;
                this.viewCliente.getJtfRg().setValue(null);
                this.viewCliente.getJtfRg().grabFocus();
                return false;
            } else if (Valida.verificarVazio(this.viewCliente.getJtfNome().getText().trim())) {
                JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfNome().grabFocus();
                return false;
            } else if (Valida.validarNome(this.viewCliente.getJtfNome().getText().trim())) {
                JOptionPane.showMessageDialog(null, Mensagem.nomeInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfNome().setText("");
                this.viewCliente.getJtfNome().grabFocus();
                return false;
            } else if (Valida.verificarVazio(this.viewCliente.getJtfDataNascimento().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.dataNascimentoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfDataNascimento().setValue(null);
                this.viewCliente.getJtfDataNascimento().grabFocus();
                return false;
            } else if (!Valida.validarData(this.viewCliente.getJtfDataNascimento().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.dataNascimentoInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfDataNascimento().setValue(null);
                this.viewCliente.getJtfDataNascimento().grabFocus();
                return false;
            }
        } else if (this.viewCliente.getJrbJuridico().isSelected()) {
            if (Valida.verificarVazio(this.viewCliente.getJtfCpf().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.cnpjVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfCpf().grabFocus();
                return false;
            } else if (!Valida.validarCnpj(this.viewCliente.getJtfCpf().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.cnpjInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfCpf().setValue(null);
                this.viewCliente.getJtfCpf().grabFocus();
                return false;
            } else if (Valida.verificarVazio(this.viewCliente.getJtfRg().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.ieVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfRg().grabFocus();
                return false;
            } else if (!Valida.validarInscricaoEstadual(this.viewCliente.getJtfRg().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.ieInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfRg().setValue(null);
                this.viewCliente.getJtfRg().grabFocus();
                return false;
            } else if (Valida.verificarVazio(this.viewCliente.getJtfNome().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.razaoSocialVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfNome().grabFocus();
                return false;
            } else if (!Valida.validarRazaoSocial(this.viewCliente.getJtfNome().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.razaoSocialInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfNome().setText("");
                this.viewCliente.getJtfNome().grabFocus();
                return false;
            } else if (Valida.verificarVazio(this.viewCliente.getJtfDataNascimento().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.dataFundacaoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfDataNascimento().grabFocus();
                return false;
            } else if (!Valida.validarData(this.viewCliente.getJtfDataNascimento().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.dataFundacaoInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfDataNascimento().setValue(null);
                this.viewCliente.getJtfDataNascimento().grabFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, Mensagem.pessoaFisicaOuJuridica);
            return false;
        }
        if (Valida.verificarVazio(this.viewCliente.getJtfEndereco().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.enderecoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewCliente.getJtfEndereco().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewCliente.getJtfNumero().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewCliente.getJtfNumero().grabFocus();
            return false;
        } else if (!Valida.validarNumero(this.viewCliente.getJtfNumero().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewCliente.getJtfNumero().setText("");
            this.viewCliente.getJtfNumero().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewCliente.getJtfBairro().getText().trim())) {
            JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewCliente.getJtfBairro().grabFocus();
            return false;
        } else if (Valida.verificarCombo(this.viewCliente.getJcbCidade().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewCliente.getJcbCidade().grabFocus();
            return false;
        } else if (Valida.verificarVazio(this.viewCliente.getJtfCep().getText())) {
            JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewCliente.getJtfCep().setValue(null);
            this.viewCliente.getJtfCep().grabFocus();
            return false;
        } else if (Valida.verificarCombo(this.viewCliente.getJcbEstado().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
            this.viewCliente.getJcbEstado().grabFocus();
            return false;
        } else if (!Valida.verificarVazio(this.viewCliente.getJtfEmail().getText())) {
            if (!Valida.validarEmail(this.viewCliente.getJtfEmail().getText())) {
                JOptionPane.showMessageDialog(null, Mensagem.emailInvalido, Mensagem.atencao, JOptionPane.WARNING_MESSAGE);
                this.viewCliente.getJtfEmail().setText("");
                this.viewCliente.getJtfEmail().grabFocus();
                return false;
            }
        }
        return true;
    }

}
