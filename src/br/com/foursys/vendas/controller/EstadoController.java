/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.EstadoDAO;
import br.com.foursys.vendas.model.Estado;
import java.util.ArrayList;

/**
 *Classe responsável por controlar todo o processamento de dados relacionados à
 * combo de estado
 * @author pbido
 */
public class EstadoController {

    public ArrayList<Estado> buscarTodos() throws Exception {
        EstadoDAO dao = new EstadoDAO();
        ArrayList<Estado> lista = dao.buscarTodos();
        return lista;
    }
}
