package br.com.foursys.vendas.teste;

import br.com.foursys.vendas.dao.ProdutoDAO;
import br.com.foursys.vendas.model.Produto;
import br.com.foursys.vendas.model.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author pbido
 */
public class ProdutoTeste {

    public static void main(String[] jumpsuit) throws Exception {
        new ProdutoTeste().salvarProduto();
    }

    public void salvarProduto() {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setIdFornecedor(1);
        produto.setFornecedorIdFornecedor(fornecedor);
        produto.setDescricao("Porta Retrato");
        produto.setValorVenda(10);
        produto.setValorCusto(6);
        dao.salvar(produto);
        System.out.println("Produto salvo com sucesso!");
        System.exit(0);
    }

    public void buscarCodigo() throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = dao.buscarPorCodigo(1);
        System.out.println("Descrição: " + produto.getDescricao());
        System.out.println("Preço: " + produto.getValorVenda());
        System.out.println("Custo: " + produto.getValorCusto());
        System.out.println("Razão Social: " + produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        System.out.println("CNPJ: " + produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getCnpj());
        System.out.println("IE: " + produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
        System.out.println("Data da Fundação: " + produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
        System.out.println("Logradouro: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getLogradouro()
                + ", " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getNumero()
                + " " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getComplemento());
        System.out.println("Bairro: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getBairro());
        System.out.println("CEP: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCep());
        System.out.println("Cidade: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getNome());
        System.out.println("Estado: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome()
                + " - " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
        System.out.println("Telefone: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getTelefone());
        System.out.println("Celular: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getCelular());
        System.out.println("Email: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getEmail() + "\n");
        System.out.println("Logradouro: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getLogradouro()
                + ", " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getNumero()
                + " " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getComplemento());
        System.out.println("Bairro: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getBairro());
        System.out.println("CEP: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCep());
        System.out.println("Cidade: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getNome());
        System.out.println("Estado: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome()
                + " - " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
        System.out.println("Telefone: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getTelefone());
        System.out.println("Celular: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getCelular());
        System.out.println("Email: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getEmail() + "\n");

        System.exit(0);
    }

    public void buscarTodos() throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        ArrayList<Produto> lista = dao.buscarTodos();
        for (Produto produto : lista) {
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: " + produto.getValorVenda());
            System.out.println("Custo: " + produto.getValorCusto());
            System.out.println("Razão Social: " + produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
            System.out.println("CNPJ: " + produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getCnpj());
            System.out.println("IE: " + produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
            System.out.println("Data da Fundação: " + produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
            System.out.println("Logradouro: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getLogradouro()
                    + ", " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getNumero()
                    + " " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getComplemento());
            System.out.println("Bairro: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getBairro());
            System.out.println("CEP: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCep());
            System.out.println("Cidade: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            System.out.println("Estado: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome()
                    + " - " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
            System.out.println("Telefone: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getTelefone());
            System.out.println("Celular: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getCelular());
            System.out.println("Email: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getEmail() + "\n");
            System.out.println("Logradouro: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getLogradouro()
                    + ", " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getNumero()
                    + " " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getComplemento());
            System.out.println("Bairro: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getBairro());
            System.out.println("CEP: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCep());
            System.out.println("Cidade: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getNome());
            System.out.println("Estado: " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome()
                    + " - " + produto.getFornecedorIdFornecedor().getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getUf());
            System.out.println("Telefone: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getTelefone());
            System.out.println("Celular: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getCelular());
            System.out.println("Email: " + produto.getFornecedorIdFornecedor().getContatoIdContato().getEmail() + "\n");
        }
        System.exit(0);
    }

}
