package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Compra;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author pbido
 */
public class CompraDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Compra> buscarTodos() throws Exception {
        ArrayList<Compra> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Compra.class);
        criteria.addOrder(Order.asc("idCompra"));
        listaRetorno = (ArrayList<Compra>) criteria.list();
        return listaRetorno;
    }

    public Compra buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Compra compra = (Compra) sessao.get(Compra.class, codigo);
        return compra;
    }
}
