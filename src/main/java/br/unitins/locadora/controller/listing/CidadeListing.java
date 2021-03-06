package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.model.Cidade;
import br.unitins.locadora.repository.CidadeRepository;
import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;

@Named
@ViewScoped
public class CidadeListing extends Listing<Cidade> {

	private static final long serialVersionUID = -27862380836522421L;
	private String filtro;

	public CidadeListing() {
		super("cidadelisting", new CidadeRepository());
	}

	@Override
	public void pesquisar() {
		CidadeRepository repo = new CidadeRepository();
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