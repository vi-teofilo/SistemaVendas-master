package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.util.Mensagem;
import br.com.foursys.vendas.view.MenuPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author pbido
 */
public class MenuController {

    private MenuPrincipal viewMenu;

    public MenuController(MenuPrincipal viewMenu) {
        this.viewMenu = viewMenu;
    }

    public void exibeNomeUsuario(String nome) {
        this.viewMenu.getJblUsuario().setText(nome);
    }

    public void acaoBotaoSair() {
        int x = JOptionPane.showConfirmDialog(null, Mensagem.confirmaEncerrar, Mensagem.atencao,
                JOptionPane.YES_NO_OPTION);
        if ((x == JOptionPane.YES_OPTION)) {
            System.exit(0);
        }
    }
}
