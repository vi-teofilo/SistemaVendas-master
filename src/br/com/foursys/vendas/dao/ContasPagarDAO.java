package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.ContasPagar;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author pbido
 */
public class ContasPagarDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<ContasPagar> buscarTodos() throws Exception {
        ArrayList<ContasPagar> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(ContasPagar.class);
        criteria.addOrder(Order.asc("idContasPagar"));
        listaRetorno = (ArrayList<ContasPagar>) criteria.list();
        return listaRetorno;
    }

    public ContasPagar buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        ContasPagar contasPagar = (ContasPagar) sessao.get(ContasPagar.class, codigo);
        return contasPagar;
    }
}
