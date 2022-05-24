package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.repository.CarroRepository;
import br.unitins.locadora.model.Carro;

@Named
@ViewScoped
public class CarroListing extends Listing<Carro>{

	private static final long serialVersionUID = 7261856882071066690L;
	private String filtro;
	
	public CarroListing() {
		super("carrolisting", new CarroRepository());
	}

	@Override
	public void pesquisar() {
		CarroRepository repo = new CarroRepository();
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
