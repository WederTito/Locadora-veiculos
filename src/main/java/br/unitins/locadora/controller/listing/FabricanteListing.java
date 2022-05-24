package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.repository.FabricanteRepository;
import br.unitins.locadora.model.Fabricante;

@Named
@ViewScoped
public class FabricanteListing extends Listing<Fabricante>{

	private static final long serialVersionUID = 7261856882071066690L;
	private String filtro;
	
	public FabricanteListing() {
		super("fabricantelisting", new FabricanteRepository());
	}

	@Override
	public void pesquisar() {
		FabricanteRepository repo = new FabricanteRepository();
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
