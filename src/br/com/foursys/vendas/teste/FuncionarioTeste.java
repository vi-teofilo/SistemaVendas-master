package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.FuncionarioDAO;
import br.com.foursys.vendas.dao.PessoaFisicaDAO;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.model.Endereco;
import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.model.PessoaFisica;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class FuncionarioTeste {

    public static void main(String[] horizon) throws Exception {
        new FuncionarioTeste().buscarTodos();
    }

    public void salvarFuncionario() {
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisica pessoaFisica = new PessoaFisica();

        pessoaFisica.setNome("João da Silva");
        pessoaFisica.setCpf("123.456.789-90");
        pessoaFisica.setRg("12.235.654-5");
        pessoaFisica.setDataNascimento("04/08/1996");
        pessoaFisicaDAO.salvar(pessoaFisica);
        funcionario.setPessoaFisicaIdPessoaFisica(pessoaFisica);
        funcionario.setSenha("tinhaespaconaporta");
        funcionario.setLogin("oregresso");
        Endereco endereco = new Endereco();
        endereco.setIdEndereco(1);
        funcionario.setEnderecoIdEndereco(endereco);
        Contato contato = new Contato();
        contato.setIdContato(1);
        funcionario.setContatoIdContato(contato);
        dao.salvar(funcionario);
        System.out.println("Funcionario salvo com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario funcionario = dao.buscarPorCodigo(1);
        System.out.println("Nome: " + funcionario.getPessoaFisicaIdPessoaFisica().getNome());
        System.out.println("RG: " + funcionario.getPessoaFisicaIdPessoaFisica().getRg());
        System.out.println("CPF: " + funcionario.getPessoaFisicaIdPessoaFisica().getCpf());
        System.out.println("Data de Nascimento: " + funcionario.getPessoaFisicaIdPessoaFisica().getDataNascimento());
        System.out.println("Login: " + funcionario.getLogin());
        System.out.println("Senha: " + funcionario.getSenha());
        System.out.println("Logradouro: " + funcionario.getEnderecoIdEndereco().getLogradouro());
        System.out.println("Número: " + funcionario.getEnderecoIdEndereco().getNumero());
        System.out.println("Complemento: " + funcionario.getEnderecoIdEndereco().getComplemento());
        System.out.println("Bairro: " + funcionario.getEnderecoIdEndereco().getBairro());
        System.out.println("CEP: " + funcionario.getEnderecoIdEndereco().getCep());
        System.out.println("Cidade: " + funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
        System.out.println("Estado: " + funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
        System.out.println("UF: " + funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
        System.out.println("Telefone: " + funcionario.getContatoIdContato().getTelefone());
        System.out.println("Celular: " + funcionario.getContatoIdContato().getCelular());
        System.out.println("Email: " + funcionario.getContatoIdContato().getEmail());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        FuncionarioDAO dao = new FuncionarioDAO();
        ArrayList<Funcionario> lista = dao.buscarTodos();
        for (Funcionario funcionario : lista) {
            System.out.println("Nome: " + funcionario.getPessoaFisicaIdPessoaFisica().getNome());
            System.out.println("RG: " + funcionario.getPessoaFisicaIdPessoaFisica().getRg());
            System.out.println("CPF: " + funcionario.getPessoaFisicaIdPessoaFisica().getCpf());
            System.out.println("Data de Nascimento: " + funcionario.getPessoaFisicaIdPessoaFisica().getDataNascimento());
            System.out.println("Login: " + funcionario.getLogin());
            System.out.println("Senha: " + funcionario.getSenha());
            System.out.println("Logradouro: " + funcionario.getEnderecoIdEndereco().getLogradouro());
            System.out.println("Número: " + funcionario.getEnderecoIdEndereco().getNumero());
            System.out.println("Complemento: " + funcionario.getEnderecoIdEndereco().getComplemento());
            System.out.println("Bairro: " + funcionario.getEnderecoIdEndereco().getBairro());
            System.out.println("CEP: " + funcionario.getEnderecoIdEndereco().getCep());
            System.out.println("Cidade: " + funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            System.out.println("Estado: " + funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
            System.out.println("UF: " + funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
            System.out.println("Telefone: " + funcionario.getContatoIdContato().getTelefone());
            System.out.println("Celular: " + funcionario.getContatoIdContato().getCelular());
            System.out.println("Email: " + funcionario.getContatoIdContato().getEmail() + "\n");
        }
        System.exit(0);
    }
}
