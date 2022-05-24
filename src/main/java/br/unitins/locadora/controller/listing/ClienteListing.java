package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.repository.ClienteRepository;
import br.unitins.locadora.model.Cliente;

@Named
@ViewScoped
public class ClienteListing extends Listing<Cliente>{

	private static final long serialVersionUID = 7261856882071066690L;
	private String filtro;
	
	public ClienteListing() {
		super("clientelisting", new ClienteRepository());
	}

	@Override
	public void pesquisar() {
		ClienteRepository repo = new ClienteRepository();
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
