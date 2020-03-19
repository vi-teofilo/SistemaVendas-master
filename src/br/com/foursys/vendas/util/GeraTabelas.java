/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.util;

/**
 *
 * @author pbido
 */
public class GeraTabelas {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
    }
}
