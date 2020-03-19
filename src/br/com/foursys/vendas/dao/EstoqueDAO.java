package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Estoque;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author pbido
 */
public class EstoqueDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Estoque> buscarTodos() throws Exception {
        ArrayList<Estoque> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Estoque.class);
        criteria.addOrder(Order.asc("quantidadeMinima"));
        listaRetorno = (ArrayList<Estoque>) criteria.list();
        return listaRetorno;
    }

    public Estoque buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Estoque estoque = (Estoque) sessao.get(Estoque.class, codigo);
        return estoque;
    }
}
