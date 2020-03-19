/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ItemVendaDAO;
import br.com.foursys.vendas.model.ItemVenda;
import br.com.foursys.vendas.model.Venda;
import br.com.foursys.vendas.util.Mensagem;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pbido
 */
public class ItemVendaController {

    public void excluirItemVenda(Venda venda) {
        try {
            ItemVendaDAO dao = new ItemVendaDAO();
            ArrayList<ItemVenda> listaExcluir = new ArrayList<>();
            listaExcluir = dao.buscarTodos();
            for (ItemVenda itemVenda : listaExcluir) {
                if (itemVenda.getVendaIdVenda().getIdVenda()== venda.getIdVenda()) {
                    dao.excluir(itemVenda);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, Mensagem.erroExcluirEndereco);
            Logger.getLogger(EnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
