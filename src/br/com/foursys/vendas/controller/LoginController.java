package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.view.LoginPrincipal;
import br.com.foursys.vendas.view.MenuPrincipal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dmunhoz
 */
public class LoginController {

    private LoginPrincipal viewLogin;

    public LoginController(LoginPrincipal viewLogin) {
        this.viewLogin = viewLogin;
    }

    public void loginSistema() {
        if (this.viewLogin.getJtfLogin().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, Mensagem.loginVazio);
        } else {
            List<Funcionario> listaFuncionario = new FuncionarioController().buscarTodos(this.viewLogin.getJtfLogin().getText());
            int contLogin = 0;
            int contSenha = 0;
            for (Funcionario funcionario : listaFuncionario) {
                contLogin++;
                if (funcionario.getSenha().equals(this.viewLogin.getJtfSenha().getText())) {
                    this.viewLogin.dispose();
                    new MenuPrincipal(funcionario.getPessoaFisicaIdPessoaFisica().getNome());
                } else {
                    contSenha++;
                }
            }
            if (contLogin == 0) {
                JOptionPane.showMessageDialog(null, Mensagem.loginInvalido, Mensagem.erro, JOptionPane.ERROR_MESSAGE);
            } else if (contSenha > 0) {
                JOptionPane.showMessageDialog(null, Mensagem.senhaInvalido, Mensagem.erro, JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
