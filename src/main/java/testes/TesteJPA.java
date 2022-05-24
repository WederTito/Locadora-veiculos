package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unitins.locadora.model.Usuario;

public class TesteJPA {
	public static void main(String[] args) {
		// teste de selecao em uma tabela para gerar o banco de dados.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Locadora");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Tito");
		usuario.setSenha("2323");
		usuario.setCpf("23232323233");
		
		em.getTransaction().begin();
		usuario = em.merge(usuario);
		em.getTransaction().commit();
		
		System.out.println("feito.");
	}
}
