package br.unitins.locadora.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.model.Carro;
import br.unitins.locadora.model.Cliente;
import br.unitins.locadora.model.Estado;

public class CarroRepository extends Repository<Carro>{
	public List<Carro> findByNome(String nome, Integer maxResults) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Carro u ");
			jpql.append("WHERE ");
			jpql.append("  u.nome LIKE :nome ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");
			
			if (maxResults != null)
				query.setMaxResults(maxResults);
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}
	public List<Carro> findByNome(String nome) throws RepositoryException {
		return findByNome(nome, null);
	}
}
