package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.PessoaFisica;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author pbido
 */
public class PessoaFisicaDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<PessoaFisica> buscarTodos() throws Exception {
        ArrayList<PessoaFisica> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(PessoaFisica.class);
        criteria.addOrder(Order.asc("idPessoaFisica"));
        listaRetorno = (ArrayList<PessoaFisica>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public PessoaFisica buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        PessoaFisica pessoaFisica = (PessoaFisica) sessao.get(PessoaFisica.class, codigo);
        sessao.close();
        return pessoaFisica;
    }
}
