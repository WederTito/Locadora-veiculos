package br.unitins.locadora.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.locadora.application.JPAUtil;
import br.unitins.locadora.model.RecuperarSenha;

public class RecuperaSenhaRepository extends Repository<RecuperarSenha> {

	private static EntityManager em = JPAUtil.getEntityManager();

	public RecuperarSenha findByCodigo(String codigo) {

		RecuperarSenha obj = null;
		Query query = em.createQuery("SELECT r FROM RecuperarSenha r WHERE r.codigo = :codigo");
		query.setParameter("codigo", codigo);

		obj = (RecuperarSenha) query.getSingleResult();

		return obj;

	}

	public void adicionar(RecuperarSenha obj) {
		// TODO Auto-generated method stub
		
	}

	
}
