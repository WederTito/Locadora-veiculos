package br.unitins.locadora.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.controller.listing.CidadeListing;
import br.unitins.locadora.controller.listing.PessoaFisicaListing;
import br.unitins.locadora.model.Cidade;
import br.unitins.locadora.model.PessoaFisica;
import br.unitins.locadora.repository.PessoaFisicaRepository;


@Named
@ViewScoped
public class PessoaFisicaController extends Controller<PessoaFisica> implements Serializable {

	private static final long serialVersionUID = -3236682773291811713L;
	
	
	public PessoaFisicaController() {
		super(new PessoaFisicaRepository());
	}
	
	@Override
	protected void limparRelacionamentosNaoObrigatorios() {
		if (getEntity().getCidade().getId() == null)
			getEntity().setCidade(null);
	}
	
	@Override
	public PessoaFisica getEntity() {
		if (entity == null) {
			entity = new PessoaFisica();
			entity.setCidade(new Cidade());
		}
		
		return entity;
	}
	
	public void abrirPessoaFisicaListing() {
		PessoaFisicaListing listing = new PessoaFisicaListing();
		listing.open();
	}
	
	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
		setEntity(event.getObject());
	}
	
	public void abrirCidadeListing() {
		CidadeListing listing = new CidadeListing();
		listing.open();
	}
	
	public void obterCidadeListing(SelectEvent<Cidade> event) {
		getEntity().setCidade(event.getObject());
	}
	

}
