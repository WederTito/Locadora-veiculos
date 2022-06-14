package br.unitins.locadora.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.model.Categoria;
import br.unitins.locadora.model.Estado;

public class CategoriaRepository extends Repository<Categoria>{
	
	public List<Categoria> findByNome(String nome, Integer maxResults) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  c ");
			jpql.append("FROM ");
			jpql.append("  Categoria c ");
			jpql.append("WHERE ");
			jpql.append("  c.nome LIKE :nome ");
			
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
	public List<Categoria> findByNome(String nome) throws RepositoryException {
		return findByNome(nome, null);
	}
}
