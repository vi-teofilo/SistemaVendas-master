/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.dao.CidadeDAO;
import br.com.foursys.vendas.model.Cidade;
import java.util.ArrayList;

/**
 *Classe responsável por controlar todo o processamento de dados relacionados à
 * combo de cidade
 * @author pbido
 */
public class CidadeController {

    public ArrayList<Cidade> buscarTodos() throws Exception {
        CidadeDAO dao = new CidadeDAO();
        ArrayList<Cidade> lista = dao.buscarTodos();
        return lista;
    }
}
