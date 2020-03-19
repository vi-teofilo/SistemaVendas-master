package br.com.foursys.vendas.util;

/**
 * Classe responsável por armazenar todas as mensagens que serão usadas entre as
 * telas do sistema de vendas
 *
 * @author pbido
 */
public class Mensagem {

    //mensagens pessoa física
    public static String cpfInvalido = "O CPF informado é inválido!";
    public static String cpfVazio = "Por favor, informe o CPF.\nCampo obrigatório!";
    public static String rgInvalido = "O RG informado é inválido!";
    public static String rgVazio = "Por favor, informe o RG.\nCampo obrigatório!";
    public static String dataNascimentoVazio = "Por favor, informe a data de nascimento.\nCampo obrigatório!";
    public static String dataNascimentoInvalido = "A data de nascimento informada é inválida!";
    public static String nomeVazio = "Por favor, informe o nome.\nCampo obrigatório!";
    public static String nomeInvalido = "O nome informado é inválido!";
    //mensagens endereço
    public static String enderecoVazio = "Por favor, informe o endereço.\nCampo obrigatório!";
    public static String numeroVazio = "Por favor, informe o número.\nCampo obrigatório!";
    public static String numeroInvalido = "O número informado é inválido!";
    public static String bairroVazio = "Por favor, informe o bairro.\nCampo obrigatório!";
    public static String cepVazio = "Por favor, informe o CEP.\nCampo obrigatório!";
    public static String cidadeVazio = "Por favor, selecione a cidade.\nCampo obrigatório!";
    public static String estadoVazio = "Por favor, selecione o estado.\nCampo obrigatório!";
    public static String erroEndereco = "Erro ao salvar endereço!";
    public static String erroExcluirEndereco = "Erro ao excluir endereço!";
    //mensagens email, loguin e senha
    public static String emailInvalido = "O email informado é inválido!";
    public static String loginVazio = "Por favor, informe o login.\nCampo obrigatório!";
    public static String loginInvalido = "Login inválido";
    public static String senhaInvalido = "Senha inválida.";
    public static String senhaVazio = "Por favor, informe a senha.\nCampo obrigatório!";
    //mensagens funcionário
    public static String funcionarioNaoSelecionado = "Por favor, selecione um funcionário para realizar esta ação.";
    public static String funcionarioExcluidoSucesso = "Funcionário excluído com sucesso.";
    public static String funcionarioExcluidoErro = "Falha ao excluir funcionário.";
    public static String funcionarioInseridoSucesso = "Funcionário inserido com sucesso.";
    public static String funcionarioInseridoErro = "Falha ao inserir funcionário.";
    public static String funcionarioAlteradoSucesso = "Funcionário alterado com sucesso.";
    public static String funcionarioAlteradoErro = "Falha ao alterar funcionário.";
    //mensagens fornecedor
    public static String fornecedorNaoSelecionado = "Por favor, selecione um fornecedor para realizar esta ação.";
    public static String fornecedorExcluidoSucesso = "Fornecedor excluído com sucesso.";
    public static String fornecedorExcluidoErro = "Falha ao excluir fornecedor.";
    public static String fornecedorInseridoSucesso = "Fornecedor inserido com sucesso.";
    public static String fornecedorInseridoErro = "Falha ao inserir fornecedor.";
    public static String fornecedorAlteradoSucesso = "Fornecedor alterado com sucesso.";
    public static String fornecedorAlteradoErro = "Falha ao alterar fornecedor.";
    //mensagens cliente
    public static String clienteNaoSelecionado = "Por favor, selecione um cliente para realizar esta ação.";
    public static String clienteExcluidoSucesso = "Cliente excluído com sucesso.";
    public static String clienteExcluidoErro = "Falha ao excluir cliente.";
    public static String clienteInseridoSucesso = "Cliente inserido com sucesso.";
    public static String clienteInseridoErro = "Falha ao inserir cliente.";
    public static String clienteAlteradoSucesso = "Cliente alterado com sucesso.";
    public static String clienteAlteradoErro = "Falha ao alterar cliente.";
    //mensagens de contato
    public static String erroContato = "Erro ao inserir contato!";
    public static String erroExcluirContato = "Erro ao excluir endereço!";
    //mensagens cidade e estado
    public static String defaultComboCidade = "-Selecione uma cidade-";
    public static String defaultComboEstado = "-Selecione um estado-";
    public static String defaultComboFuncionario = "-Selecione um funcionário-";
    public static String defaultComboCliente = "-Selecione um cliente-";
    //mensagem definição de pessoa
    public static String pessoaFisicaOuJuridica = "Selecione pessoa física ou pessoa jurídica.";
    //mensagens pessoa juridica
    public static String cnpjVazio = "Por favor, informe o CNPJ.\nCampo obrigatório!";
    public static String cnpjInvalido = "O CNPJ informado é inválido!";
    public static String ieVazio = "Por favor, informe a Inscrição Estadual.\nCampo obrigatório!";
    public static String ieInvalido = "A Inscrição Estadual informada é inválida!";
    public static String razaoSocialVazio = "Por favor, informe a Razão Social.\nCampo obrigatório!";
    public static String razaoSocialInvalido = "A Razão Social informada é inválida!";
    public static String dataFundacaoVazio = "Por favor, informe a Data da Fundação.\nCampo obrigatório!";
    public static String dataFundacaoInvalido = "A Data da Fundação informada é inválida!";
    //mensagens produto 
    public static String produtoNaoSelecionado = "Por favor, selecione um produto para realizar esta ação.";
    public static String produtoExcluidoSucesso = "Produto excluido com sucesso.";
    public static String produtoExcluidoErro = "Falha ao excluir produto.";
    public static String defaultComboFornecedor = "-Selecione um fornecedor-";
    public static String defaultComboProduto = "-Selecione um produto-";
    public static String produtoDescricaoVazio = "Por favor, informe a descrição.\nCampo obrigatório!";
    public static String produtoFornecedorVazio = "Por favor, selecione o fornecedor.\nCampo obrigatório!";
    public static String produtoValorCustoVazio = "Por favor, informe o valor de custo.\nCampo obrigatório!";
    public static String produtoValorCustoInvalido = "O valor de custo informado é inválido.";
    public static String produtoValorVendaVazio = "Por favor, informe o valor de venda.\nCampo obrigatório!";
    public static String produtoValorVendaInvalido = "O valor de venda informado é inválido.";
    public static String produtoInseridoSucesso = "Produto inserido com sucesso.";
    public static String produtoInseridoErro = "Falha ao inserir produto.";
    public static String produtoAlteradoSucesso = "Produto alterado com sucesso.";
    public static String produtoAlteradoErro = "Falha ao alterar produto.";
    public static String produtoInsuficiente = "Quantidade menor que a quantidade mínima";
    public static String produtoQuantidadeVazia = "Por favor, informe a quantidade do produto.\nCampo obrigatório!";
    public static String produtoQuantidadeInvalida = "Quantidade de produto inválida.";
    public static String produtoDescontoInvalido = "Desconto inválido.";
    public static String produtoValorTotalInvalido = "Valor total inválido.\nFavor verificar sua compra.";
    public static String pagamentoNaoSelecionado = "Selecione uma forma de pagamento.";

    //mensagens Estoque
    public static String estoqueExcluidoSucesso = "Estoque excluído com sucesso!";
    public static String estoqueExcluidoErro = "Falha ao excluir estoque!";
    public static String estoqueQuantidadeMaximaVazio = "Por favor, informe a quantidade máxima.\nCampo obrigatório!";
    public static String estoqueQuantidadeMaximaInvalido = "A quantidade máxima informada é inválida.";
    public static String estoqueQuantidadeVazio = "Por favor, informe a quantidade.\nCampo obrigatório!";
    public static String estoqueQuantidadeInvalido = "A quantidade informada é inválida.";
    public static String estoqueInseridoSucesso = "Estoque inserido com sucesso!";
    public static String estoqueInseridoErro = "Falha ao inserir estoque!";
    public static String estoqueAlteradoSucesso = "Estoque alterado com sucesso!";
    public static String estoqueAlteradoErro = "Falha ao alterar estoque!";
    public static String estoqueNaoSelecionado = "Por favor, selecione um estoque para realizar esta ação.";
    //Mensagens Geral
    public static String confirmaSair = "Deseja realmente sair?";
    public static String atencao = " Atenção!";
    public static String confirmaEncerrar = "Deseja realmente encerrar o sistema?";
    public static String confirmaExclusao = "Confirma em excluir este registro?";
    public static String erro = "Erro!";
    public static String confirmaCancelar = "Deseja realmente cancelar?";
    //Mensagens Compra
    public static String valorMenorQueZero = "O valor não pode ser menor que zero!";
    public static String descontoMenorQueZero = "O desconto não pode ser menor que zero!";
    public static String confirmaCompra = "Deseja realmente confirmar esta compra?";
    public static String confirmaVenda = "Deseja realmente confirmar esta Venda?";
    public static String erroSalvarContaPagar = "Erro ao salvar conta a pagar";
    public static String erroSalvarContaReceber = "Erro ao salvar conta a receber";
    public static String erroSalvarCompra = "Erro ao salvar compra.";
    public static String sucessoSalvarContaPagar = "Conta a pagar salva com sucesso!";
    public static String sucessoSalvarContaReceber = "Conta a receber salva com sucesso!";
    public static String sucessoSalvarCompra = "Compra salva com sucesso!";
    public static String sucessoSalvarVenda = "Venda salva com sucesso!";
}//fim da classe
