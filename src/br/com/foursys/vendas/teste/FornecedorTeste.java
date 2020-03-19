package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.EnderecoDAO;
import br.com.foursys.vendas.dao.FornecedorDAO;
import br.com.foursys.vendas.dao.PessoaFisicaDAO;
import br.com.foursys.vendas.dao.PessoaJuridicaDAO;
import br.com.foursys.vendas.model.Cidade;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.model.Endereco;
import br.com.foursys.vendas.model.Fornecedor;
import br.com.foursys.vendas.model.PessoaFisica;
import br.com.foursys.vendas.model.PessoaJuridica;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class FornecedorTeste {

    public static void main(String[] temaki) throws Exception {
        new FornecedorTeste().buscarTodos();
    }

    public void salvarFornecedorFisico() {
        FornecedorDAO dao = new FornecedorDAO();
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setContato("Teste");

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

        pessoaJuridica.setRazaoSocial("João Carlos da Silva Sauro");
        pessoaJuridica.setInscricaoEstadual("23.789.123-87");
        pessoaJuridica.setCnpj("124.897.776-76");
        pessoaJuridica.setDataFundacao("04/11/1987");

        pessoaJuridicaDAO.salvar(pessoaJuridica);
        fornecedor.setPessoaJuridicaIdPessoaJuridica(pessoaJuridica);

        dao.salvar(fornecedor);

        System.out.println("Fornecedor salvo com sucesso!");
        System.exit(0);
    }

    public void salvarFornecedorJuridico() {
        FornecedorDAO dao = new FornecedorDAO();
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setContato("Teste");

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

        pessoaJuridica.setRazaoSocial("Jubileu Transportadora e Logistica");
        pessoaJuridica.setCnpj("12.356.876/0001-22");
        pessoaJuridica.setInscricaoEstadual("110.042.490.114");
        pessoaJuridica.setDataFundacao("06/01/1985");
        pessoaJuridicaDAO.salvar(pessoaJuridica);

        fornecedor.setPessoaJuridicaIdPessoaJuridica(pessoaJuridica);

        dao.salvar(fornecedor);

        System.out.println("Fornecedor salvo com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        FornecedorDAO dao = new FornecedorDAO();
        Fornecedor fornecedor = dao.buscarPorCodigo(7);
        System.out.println("Logradouro: " + fornecedor.getEnderecoIdEndereco().getLogradouro()
                + ", " + fornecedor.getEnderecoIdEndereco().getNumero()
                + " " + fornecedor.getEnderecoIdEndereco().getComplemento());
        System.out.println("Bairro: " + fornecedor.getEnderecoIdEndereco().getBairro());
        System.out.println("CEP: " + fornecedor.getEnderecoIdEndereco().getCep());
        System.out.println("Cidade: " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
        System.out.println("Estado: " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome()
                + " - " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
        System.out.println("Telefone: " + fornecedor.getContatoIdContato().getTelefone());
        System.out.println("Celular: " + fornecedor.getContatoIdContato().getCelular());
        System.out.println("Email: " + fornecedor.getContatoIdContato().getEmail());
        System.out.println("Razão Social: " + fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        System.out.println("CNPJ: " + fornecedor.getPessoaJuridicaIdPessoaJuridica().getCnpj());
        System.out.println("IE: " + fornecedor.getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
        System.out.println("Data da Fundação: " + fornecedor.getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
        System.out.println("Logradouro: " + fornecedor.getEnderecoIdEndereco().getLogradouro()
                + ", " + fornecedor.getEnderecoIdEndereco().getNumero()
                + " " + fornecedor.getEnderecoIdEndereco().getComplemento());
        System.out.println("Bairro: " + fornecedor.getEnderecoIdEndereco().getBairro());
        System.out.println("CEP: " + fornecedor.getEnderecoIdEndereco().getCep());
        System.out.println("Cidade: " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
        System.out.println("Estado: " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome()
                + " - " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
        System.out.println("Telefone: " + fornecedor.getContatoIdContato().getTelefone());
        System.out.println("Celular: " + fornecedor.getContatoIdContato().getCelular());
        System.out.println("Email: " + fornecedor.getContatoIdContato().getEmail());
        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        FornecedorDAO dao = new FornecedorDAO();
        ArrayList<Fornecedor> lista = dao.buscarTodos();
        for (Fornecedor fornecedor : lista) {
            System.out.println("Logradouro: " + fornecedor.getEnderecoIdEndereco().getLogradouro()
                    + ", " + fornecedor.getEnderecoIdEndereco().getNumero()
                    + " " + fornecedor.getEnderecoIdEndereco().getComplemento());
            System.out.println("Bairro: " + fornecedor.getEnderecoIdEndereco().getBairro());
            System.out.println("CEP: " + fornecedor.getEnderecoIdEndereco().getCep());
            System.out.println("Cidade: " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            System.out.println("Estado: " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome()
                    + " - " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
            System.out.println("Telefone: " + fornecedor.getContatoIdContato().getTelefone());
            System.out.println("Celular: " + fornecedor.getContatoIdContato().getCelular());
            System.out.println("Email: " + fornecedor.getContatoIdContato().getEmail() + "\n");
            System.out.println("Razão Social: " + fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
            System.out.println("CNPJ: " + fornecedor.getPessoaJuridicaIdPessoaJuridica().getCnpj());
            System.out.println("IE: " + fornecedor.getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
            System.out.println("Data da Fundação: " + fornecedor.getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
            System.out.println("Logradouro: " + fornecedor.getEnderecoIdEndereco().getLogradouro()
                    + ", " + fornecedor.getEnderecoIdEndereco().getNumero()
                    + " " + fornecedor.getEnderecoIdEndereco().getComplemento());
            System.out.println("Bairro: " + fornecedor.getEnderecoIdEndereco().getBairro());
            System.out.println("CEP: " + fornecedor.getEnderecoIdEndereco().getCep());
            System.out.println("Cidade: " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            System.out.println("Estado: " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome()
                    + " - " + fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
            System.out.println("Telefone: " + fornecedor.getContatoIdContato().getTelefone());
            System.out.println("Celular: " + fornecedor.getContatoIdContato().getCelular());
            System.out.println("Email: " + fornecedor.getContatoIdContato().getEmail() + "\n");
        }
        System.exit(0);
    }
}
