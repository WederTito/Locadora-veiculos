package br.unitins.locadora.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.model.Locacao;

public class LocacaoRepository extends Repository<Locacao>{
	public List<Locacao> findByNome(String nome) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  l ");
			jpql.append("FROM ");
			jpql.append("  Locacao l ");
			jpql.append("WHERE ");
			jpql.append("  l.nome LIKE :nome ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}
}
