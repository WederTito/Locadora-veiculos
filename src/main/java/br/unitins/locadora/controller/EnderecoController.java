package br.unitins.locadora.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;


import br.unitins.locadora.controller.listing.EnderecoListing;
import br.unitins.locadora.controller.listing.CidadeListing;
import br.unitins.locadora.model.Endereco;
import br.unitins.locadora.model.Cidade;
import br.unitins.locadora.repository.EnderecoRepository;

@Named
@ViewScoped
public class EnderecoController extends Controller<Endereco> implements Serializable {

	private static final long serialVersionUID = 3557577173819542977L;

	public EnderecoController() {
		super(new EnderecoRepository());
	}
	
	@Override
	public Endereco getEntity() {
		if (entity == null) {
			entity = new Endereco();
			entity.setCidade(new Cidade());
		}
		return entity;
	}
	
	public void abrirEnderecoListing() {
		EnderecoListing listing = new EnderecoListing();
		listing.open();
	}
	
	public void obterEnderecoListing(SelectEvent<Endereco> event) {
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