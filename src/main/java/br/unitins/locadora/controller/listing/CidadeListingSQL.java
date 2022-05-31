package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.model.Cidade;
import br.unitins.locadora.repository.CidadeRepository;
import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;

@Named
@ViewScoped
public class CidadeListingSQL extends ListingSQL<Cidade> {

	private static final long serialVersionUID = -27862380836522421L;
	private String filtro;

	public CidadeListingSQL() {
		super("cidadelistingsql", new CidadeRepository());
	}

	@Override
	public void pesquisar() {
		CidadeRepository repo = new CidadeRepository();
		try {
			setList(repo.findByNomeSQL(filtro));
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