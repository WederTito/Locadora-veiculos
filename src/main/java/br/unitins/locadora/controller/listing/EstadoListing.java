package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.repository.EstadoRepository;
import br.unitins.locadora.model.Estado;

@Named
@ViewScoped
public class EstadoListing extends Listing<Estado>{

	private static final long serialVersionUID = 7261856882071066690L;
	private String filtro;
	
	public EstadoListing() {
		super("estadolisting", new EstadoRepository());
	}

	@Override
	public void pesquisar() {
		EstadoRepository repo = new EstadoRepository();
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
