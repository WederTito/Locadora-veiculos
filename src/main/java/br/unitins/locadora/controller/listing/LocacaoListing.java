package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.repository.LocacaoRepository;
import br.unitins.locadora.model.Locacao;

@Named
@ViewScoped
public class LocacaoListing extends Listing<Locacao>{

	private static final long serialVersionUID = 7261856882071066690L;
	private String filtro;
	
	public LocacaoListing() {
		super("locacaolisting", new LocacaoRepository());
	}

	@Override
	public void pesquisar() {
		LocacaoRepository repo = new LocacaoRepository();
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
