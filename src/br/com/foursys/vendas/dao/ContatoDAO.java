package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Contato;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author pbido
 */
public class ContatoDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Contato> buscarTodos() throws Exception {
        ArrayList<Contato> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Contato.class);
        criteria.addOrder(Order.asc("idContato"));
        listaRetorno = (ArrayList<Contato>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public Contato buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Contato contato = (Contato) sessao.get(Contato.class, codigo);
        sessao.close();
        return contato;
    }
}
