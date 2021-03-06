package br.unitins.locadora.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.model.Fabricante;

public class FabricanteRepository extends Repository<Fabricante>{
	
	public List<Fabricante> findByNome(String nome) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  f ");
			jpql.append("FROM ");
			jpql.append("  Fabricante f ");
			jpql.append("WHERE ");
			jpql.append("  f.nome LIKE :nome ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}
}
