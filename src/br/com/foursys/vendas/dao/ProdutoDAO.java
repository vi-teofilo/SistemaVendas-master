package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Produto;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author pbido
 */
public class ProdutoDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Produto> buscarTodos() throws Exception {
        ArrayList<Produto> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Produto.class);
        criteria.addOrder(Order.asc("idProduto"));
        listaRetorno = (ArrayList<Produto>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public Produto buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Produto produto = (Produto) sessao.get(Produto.class, codigo);
        sessao.close();
        return produto;
    }
}
