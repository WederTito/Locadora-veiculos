package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.repository.PessoaJuridicaRepository;
import br.unitins.locadora.model.PessoaJuridica;

@Named
@ViewScoped
public class PessoaJuridicaListing extends Listing<PessoaJuridica>{

	private static final long serialVersionUID = 5686318442241599690L;
	
	private String filtro;
	
	public PessoaJuridicaListing() {
		super("pessoajuridicalisting", new PessoaJuridicaRepository());
	}

	@Override
	public void pesquisar() {
		PessoaJuridicaRepository repo = new PessoaJuridicaRepository();
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
