package br.unitins.locadora.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.model.Endereco;
import br.unitins.locadora.repository.EnderecoRepository;
import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;

@Named
@ViewScoped
public class EnderecoListing extends Listing<Endereco> {

	private static final long serialVersionUID = -4323779302167142423L;
	private String filtro;

	public EnderecoListing() {
		super("enderecolisting", new EnderecoRepository());
	}

	@Override
	public void pesquisar() {
		EnderecoRepository repo = new EnderecoRepository();
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