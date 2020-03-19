package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.Funcionario;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pbido
 */
public class FuncionarioDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Funcionario> buscarTodos() throws Exception {
        ArrayList<Funcionario> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Funcionario.class);
        criteria.addOrder(Order.asc("idFuncionario"));
        listaRetorno = (ArrayList<Funcionario>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Funcionario> buscarTodos(String login) throws Exception {
        ArrayList<Funcionario> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Funcionario.class);
        criteria.add(Restrictions.ilike("login", login));
        criteria.addOrder(Order.asc("idFuncionario"));
        listaRetorno = (ArrayList<Funcionario>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public Funcionario buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Funcionario funcionario = (Funcionario) sessao.get(Funcionario.class, codigo);
        sessao.close();
        return funcionario;
    }
}
