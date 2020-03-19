package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.ItemCompra;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author pbido
 */
public class ItemCompraDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<ItemCompra> buscarTodos() throws Exception {
        ArrayList<ItemCompra> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(ItemCompra.class);
        criteria.addOrder(Order.asc("idItemCompra"));
        listaRetorno = (ArrayList<ItemCompra>) criteria.list();
        return listaRetorno;
    }

    public ItemCompra buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        ItemCompra itemCompra = (ItemCompra) sessao.get(ItemCompra.class, codigo);
        return itemCompra;
    }
}
