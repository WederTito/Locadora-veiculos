package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.repository.TelefoneRepository;
import br.unitins.locadora.model.Telefone;

@Named
@ViewScoped
public class TelefoneListing extends Listing<Telefone>{

	private static final long serialVersionUID = 7261856882071066690L;
	private String filtro;
	
	public TelefoneListing() {
		super("telefonelisting", new TelefoneRepository());
	}

	@Override
	public void pesquisar() {
		TelefoneRepository repo = new TelefoneRepository();
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
