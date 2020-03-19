package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.ContasReceber;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author pbido
 */
public class ContasReceberDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<ContasReceber> buscarTodos() throws Exception {
        ArrayList<ContasReceber> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(ContasReceber.class);
        criteria.addOrder(Order.asc("idContasReceber"));
        listaRetorno = (ArrayList<ContasReceber>) criteria.list();
        return listaRetorno;
    }

    public ContasReceber buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        ContasReceber contasReceber = (ContasReceber) sessao.get(ContasReceber.class, codigo);
        return contasReceber;
    }
}
