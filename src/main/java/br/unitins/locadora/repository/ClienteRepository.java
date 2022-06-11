package br.unitins.locadora.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.model.Carro;
import br.unitins.locadora.model.Cliente;
import br.unitins.locadora.model.Estado;

public class ClienteRepository extends Repository<Cliente>{
	
	public List<Cliente> findByNome(String nome) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Cliente u ");
			jpql.append("WHERE ");
			jpql.append("  u.nome LIKE :nome ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");
				
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}
	public Cliente findByIdPessoaFisica(int id) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Cliente u ");
			jpql.append("WHERE ");
			jpql.append("  u.pessoaFisica.id = :id ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("id", id);
			
			return (Cliente) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}		
	}

	public Cliente findByEmail(String email) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Cliente u ");
			jpql.append("WHERE ");
			jpql.append("  u.pessoaFisica.email = :email ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("email", email);
			
			return (Cliente) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}		
	}

}
