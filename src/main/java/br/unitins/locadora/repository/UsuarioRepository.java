package br.unitins.locadora.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.model.Usuario;

public class UsuarioRepository extends Repository<Usuario>{
	
	public Usuario validarLogin(Usuario usuario) throws RepositoryException {
		try { 
			EntityManager em = getEntityManager();
			//JPQL ou SQL
			Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha");
			query.setParameter("login", usuario.getLogin());
			query.setParameter("senha", Util.hash(usuario.getSenha()));
			
			return  (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			// mandando pro console o exception gerado
			e.printStackTrace();
			// repassando a excecao para quem vai executar o metodo
			throw new RepositoryException("Problema ao pesquisar usuários.");
		}
		
	}
	
	public List<Usuario> findByNome(String nome) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Usuario u ");
			jpql.append("WHERE ");
			jpql.append("  u.pessoaFisica.nome LIKE :nome ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}
	
	public Usuario findByIdPessoaFisica(int id) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Usuario u ");
			jpql.append("WHERE ");
			jpql.append("  u.pessoaFisica.id = :id ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("id", id);
			
			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}		
	}

	public Usuario findByEmail(String email) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Usuario u ");
			jpql.append("WHERE ");
			jpql.append("  u.pessoaFisica.email = :email ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("email", email);
			
			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}		
	}

	public Usuario adicionar(Usuario usu) throws RepositoryException {
	     try {
	            usu.setSenha(Util.hash(usu.getSenha()));
	            entityManager.getTransaction().begin();
	            Usuario t = entityManager.merge(usu);
	            entityManager.getTransaction().commit();
	            return t;
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RepositoryException("Erro ao adicionar!");
	        }
		
	}
	
	@SuppressWarnings("unchecked")
    public Usuario getUsuario(String login, String senha) {

        Query query = getEntityManager().createQuery("Select " + "  u " + "From " + "  Usuario u " + "WHERE "
                + "  u.login = :login AND " + "  u.senha = :senha ");

        query.setParameter("login", login);
        query.setParameter("senha", senha);

        List<Usuario> lista = query.getResultList();

        if (lista == null || lista.isEmpty())
            return null;

        return lista.get(0);
    }
}
