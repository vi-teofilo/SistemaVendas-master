package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.ItemVenda;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author pbido
 */
public class ItemVendaDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<ItemVenda> buscarTodos() throws Exception {
        ArrayList<ItemVenda> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(ItemVenda.class);
        criteria.addOrder(Order.asc("idItemVenda"));
        listaRetorno = (ArrayList<ItemVenda>) criteria.list();
        return listaRetorno;
    }

    public ItemVenda buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        ItemVenda itemVenda = (ItemVenda) sessao.get(ItemVenda.class, codigo);
        return itemVenda;
    }
}
