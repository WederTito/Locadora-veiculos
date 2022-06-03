package br.unitins.locadora.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.unitins.locadora.application.JPAUtil;
import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.model.EsqueceuSenha;

public class EsqueceuSenhaRepository extends Repository<EsqueceuSenha> {
	private static EntityManager em = JPAUtil.getEntityManager();

	public static List<EsqueceuSenha> buscarCodigo(String codigo) throws RepositoryException {
		try {
			EntityManager em = getEntityManager();
			Query query = em.createQuery(
					"SELECT e FROM EsqueceuSenha e WHERE e.id_usuario = 1 AND e.utilizado = false AND e.codigo = :codigo ORDER BY e.dataHoraLimite DESC LIMIT 1");
			query.setParameter("codigo", codigo);

			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			// mandando pro console o exception gerado
			e.printStackTrace();
			// repassando a excecao para quem vai executar o metodo
			throw new RepositoryException("Problema ao pesquisar codigo.");
		}
	}

	public EsqueceuSenha findByCodigo(String codigo) {

		EsqueceuSenha obj = null;
		Query query = em.createQuery("SELECT r FROM EsqueceuSenha r WHERE r.codigo = :codigo");
		query.setParameter("codigo", codigo);

		obj = (EsqueceuSenha) query.getSingleResult();

		return obj;

	}

	public void adicionar(EsqueceuSenha obj) {
		// TODO Auto-generated method stub
		
	}

}
