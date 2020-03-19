package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ContatoDAO;
import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.util.Mensagem;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe responsável por controlar todo o processamento de dados relacionados à
 * salvar, excluir e buscar contato
 *
 * @author dmunhoz
 */
public class ContatoController {

    // metodos responsaveis por salvar, buscar por código e excluir contato  
    public void salvarContato(Object objeto) {
        try {
            new ContatoDAO().salvar(objeto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, Mensagem.erroContato);
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirContato(Object objeto) {
        try {
            new ContatoDAO().excluir(objeto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, Mensagem.erroExcluirContato);
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Contato buscarPorCodigo(int id) {
        ContatoDAO dao = new ContatoDAO();
        Contato contato = new Contato();
        try {
            contato = dao.buscarPorCodigo(id);
        } catch (Exception ex) {
            Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contato;
    }
}
