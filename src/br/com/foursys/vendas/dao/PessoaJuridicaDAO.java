package br.com.foursys.vendas.dao;

import br.com.foursys.vendas.model.PessoaJuridica;
import br.com.foursys.vendas.util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author pbido
 */
public class PessoaJuridicaDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<PessoaJuridica> buscarTodos() throws Exception {
        ArrayList<PessoaJuridica> listaRetorno = new ArrayList<>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(PessoaJuridica.class);
        criteria.addOrder(Order.asc("idPessoaJuridica"));
        listaRetorno = (ArrayList<PessoaJuridica>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public PessoaJuridica buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        PessoaJuridica pessoaJuridica = (PessoaJuridica) sessao.get(PessoaJuridica.class, codigo);
        sessao.close();
        return pessoaJuridica;
    }
}
