package br.unitins.locadora.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.model.PessoaJuridica;

public class PessoaJuridicaRepository extends Repository<PessoaJuridica>{
	
	public List<PessoaJuridica> findByNome(String nome) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  pj ");
			jpql.append("FROM ");
			jpql.append("  PessoaJuridica pj ");
			jpql.append("WHERE ");
			jpql.append("  pj.nome LIKE :nome ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}
}
