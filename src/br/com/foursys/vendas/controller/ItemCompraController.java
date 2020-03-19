/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.ItemCompraDAO;
import br.com.foursys.vendas.model.Compra;
import br.com.foursys.vendas.model.ItemCompra;
import br.com.foursys.vendas.util.Mensagem;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pbido
 */
public class ItemCompraController {

    public void excluirItemCompra(Compra compra) {
        try {
            ItemCompraDAO dao = new ItemCompraDAO();
            ArrayList<ItemCompra> listaExcluir = new ArrayList<>();
            listaExcluir = dao.buscarTodos();
            for (ItemCompra itemCompra : listaExcluir) {
                if (itemCompra.getCompraIdCompra().getIdCompra() == compra.getIdCompra()) {
                    dao.excluir(itemCompra);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, Mensagem.erroExcluirEndereco);
            Logger.getLogger(EnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
