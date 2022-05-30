package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.repository.CategoriaRepository;
import br.unitins.locadora.model.Categoria;

@Named
@ViewScoped
public class CategoriaListing extends Listing<Categoria>{

	private static final long serialVersionUID = 951453793036428361L;
	private String filtro;
	
	public CategoriaListing() {
		super("categorialisting", new CategoriaRepository());
	}

	@Override
	public void pesquisar() {
		CategoriaRepository repo = new CategoriaRepository();
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
