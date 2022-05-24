package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.repository.PessoaFisicaRepository;
import br.unitins.locadora.model.PessoaFisica;

@Named
@ViewScoped
public class PessoaFisicaListing extends Listing<PessoaFisica>{

	private static final long serialVersionUID = 7261856882071066690L;
	
	private String filtro;
	
	public PessoaFisicaListing() {
		super("pessoafisicalisting", new PessoaFisicaRepository());
	}

	@Override
	public void pesquisar() {
		PessoaFisicaRepository repo = new PessoaFisicaRepository();
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
