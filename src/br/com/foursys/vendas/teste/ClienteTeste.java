package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.ClienteDAO;
import br.com.foursys.vendas.dao.EnderecoDAO;
import br.com.foursys.vendas.dao.PessoaFisicaDAO;
import br.com.foursys.vendas.dao.PessoaJuridicaDAO;
import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.model.Cliente;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.model.Endereco;
import br.com.foursys.vendas.model.PessoaFisica;
import br.com.foursys.vendas.model.PessoaJuridica;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class ClienteTeste {

    public static void main(String[] temaki) throws Exception {
        new ClienteTeste().buscarTodos();
    }

    public void salvarClienteFisico() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = new PessoaFisica();

        pessoaFisica.setNome("João da Silva");
        pessoaFisica.setCpf("123.456.789-90");
        pessoaFisica.setRg("12.235.654-5");
        pessoaFisica.setDataNascimento("04/08/1996");
        pessoaFisicaDAO.salvar(pessoaFisica);

        cliente.setTipoPessoa("F");
        cliente.setPessoaFisicaIdPessoaFisica(pessoaFisica);

        Endereco endereco = new Endereco();

        endereco.setIdEndereco(1);
        cliente.setEnderecoIdEndereco(endereco);

        Contato contato = new Contato();

        contato.setIdContato(1);
        cliente.setContatoIdContato(contato);

        clienteDAO.salvar(cliente);
        System.out.println("Cliente salvo com sucesso!");
        System.exit(0);
    }

    public void salvarClienteJuridico() {
        ClienteDAO dao = new ClienteDAO();
        Cliente fornecedor = new Cliente();

        fornecedor.setTipoPessoa("J");

        Endereco endereco = new Endereco();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Cidade cidade = new Cidade();
        cidade.setIdCidade(1);
        endereco.setLogradouro("Avenida Guanabara");
        endereco.setNumero(557);
        endereco.setBairro("Jardim do Rio");
        endereco.setComplemento("13º andar");
        endereco.setCep("01723-232");
        endereco.setCidadeIdCidade(cidade);
        enderecoDAO.salvar(endereco);
        fornecedor.setEnderecoIdEndereco(endereco);

        Contato contato = new Contato();
        contato.setIdContato(4);

        fornecedor.setContatoIdContato(contato);

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();

        pessoaJuridica.setRazaoSocial("Jubileu Cliente e Compradora");
        pessoaJuridica.setCnpj("12.356.876/0001-22");
        pessoaJuridica.setInscricaoEstadual("110.042.490.114");
        pessoaJuridica.setDataFundacao("06/01/1985");
        pessoaJuridicaDAO.salvar(pessoaJuridica);

        fornecedor.setPessoaJuridicaIdPessoaJuridica(pessoaJuridica);

        dao.salvar(fornecedor);

        System.out.println("Cliente salvo com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.buscarPorCodigo(1);
        if (cliente.getTipoPessoa().equals("F")) {
            System.out.println("Nome: " + cliente.getPessoaFisicaIdPessoaFisica().getNome());
            System.out.println("RG: " + cliente.getPessoaFisicaIdPessoaFisica().getRg());
            System.out.println("CPF: " + cliente.getPessoaFisicaIdPessoaFisica().getCpf());
            System.out.println("Data de Nascimento: " + cliente.getPessoaFisicaIdPessoaFisica().getDataNascimento());;
            System.out.println("Logradouro: " + cliente.getEnderecoIdEndereco().getLogradouro());
            System.out.println("Número: " + cliente.getEnderecoIdEndereco().getNumero());
            System.out.println("Complemento: " + cliente.getEnderecoIdEndereco().getComplemento());
            System.out.println("Bairro: " + cliente.getEnderecoIdEndereco().getBairro());
            System.out.println("CEP: " + cliente.getEnderecoIdEndereco().getCep());
            System.out.println("Cidade: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            System.out.println("Estado: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
            System.out.println("UF: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
            System.out.println("Telefone: " + cliente.getContatoIdContato().getTelefone());
            System.out.println("Celular: " + cliente.getContatoIdContato().getCelular());
            System.out.println("Email: " + cliente.getContatoIdContato().getEmail());
        } else {
            System.out.println("Razão Social: " + cliente.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
            System.out.println("CNPJ: " + cliente.getPessoaJuridicaIdPessoaJuridica().getCnpj());
            System.out.println("IE: " + cliente.getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
            System.out.println("Data da Fundação: " + cliente.getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
            System.out.println("Logradouro: " + cliente.getEnderecoIdEndereco().getLogradouro());
            System.out.println("Número: " + cliente.getEnderecoIdEndereco().getNumero());
            System.out.println("Complemento: " + cliente.getEnderecoIdEndereco().getComplemento());
            System.out.println("Bairro: " + cliente.getEnderecoIdEndereco().getBairro());
            System.out.println("CEP: " + cliente.getEnderecoIdEndereco().getCep());
            System.out.println("Cidade: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            System.out.println("Estado: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
            System.out.println("UF: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
            System.out.println("Telefone: " + cliente.getContatoIdContato().getTelefone());
            System.out.println("Celular: " + cliente.getContatoIdContato().getCelular());
            System.out.println("Email: " + cliente.getContatoIdContato().getEmail());
        }
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        ClienteDAO dao = new ClienteDAO();
        ArrayList<Cliente> lista = dao.buscarTodos();
        for (Cliente cliente : lista) {
            if (cliente.getTipoPessoa().equals("F")) {
                System.out.println("Nome: " + cliente.getPessoaFisicaIdPessoaFisica().getNome());
                System.out.println("RG: " + cliente.getPessoaFisicaIdPessoaFisica().getRg());
                System.out.println("CPF: " + cliente.getPessoaFisicaIdPessoaFisica().getCpf());
                System.out.println("Data de Nascimento: " + cliente.getPessoaFisicaIdPessoaFisica().getDataNascimento());;
                System.out.println("Logradouro: " + cliente.getEnderecoIdEndereco().getLogradouro());
                System.out.println("Número: " + cliente.getEnderecoIdEndereco().getNumero());
                System.out.println("Complemento: " + cliente.getEnderecoIdEndereco().getComplemento());
                System.out.println("Bairro: " + cliente.getEnderecoIdEndereco().getBairro());
                System.out.println("CEP: " + cliente.getEnderecoIdEndereco().getCep());
                System.out.println("Cidade: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
                System.out.println("Estado: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
                System.out.println("UF: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
                System.out.println("Telefone: " + cliente.getContatoIdContato().getTelefone());
                System.out.println("Celular: " + cliente.getContatoIdContato().getCelular());
                System.out.println("Email: " + cliente.getContatoIdContato().getEmail() + "\n");
            } else {
                System.out.println("Razão Social: " + cliente.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
                System.out.println("CNPJ: " + cliente.getPessoaJuridicaIdPessoaJuridica().getCnpj());
                System.out.println("IE: " + cliente.getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
                System.out.println("Data da Fundação: " + cliente.getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
                System.out.println("Logradouro: " + cliente.getEnderecoIdEndereco().getLogradouro());
                System.out.println("Número: " + cliente.getEnderecoIdEndereco().getNumero());
                System.out.println("Complemento: " + cliente.getEnderecoIdEndereco().getComplemento());
                System.out.println("Bairro: " + cliente.getEnderecoIdEndereco().getBairro());
                System.out.println("CEP: " + cliente.getEnderecoIdEndereco().getCep());
                System.out.println("Cidade: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
                System.out.println("Estado: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
                System.out.println("UF: " + cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
                System.out.println("Telefone: " + cliente.getContatoIdContato().getTelefone());
                System.out.println("Celular: " + cliente.getContatoIdContato().getCelular());
                System.out.println("Email: " + cliente.getContatoIdContato().getEmail() + "\n");
            }
        }
        System.exit(0);
    }
}
