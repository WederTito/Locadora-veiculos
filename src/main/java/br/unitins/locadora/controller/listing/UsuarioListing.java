package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.repository.UsuarioRepository;
import br.unitins.locadora.model.Usuario;

@Named
@ViewScoped
public class UsuarioListing extends Listing<Usuario>{

	private static final long serialVersionUID = 7261856882071066690L;
	private String filtro;
	
	public UsuarioListing() {
		super("usuariolisting", new UsuarioRepository());
	}

	@Override
	public void pesquisar() {
		UsuarioRepository repo = new UsuarioRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao realizar a consulta.");
		}
	}
	
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	

}
