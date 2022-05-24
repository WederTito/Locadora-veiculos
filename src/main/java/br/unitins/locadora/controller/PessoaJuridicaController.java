package br.unitins.locadora.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.controller.listing.CidadeListing;
import br.unitins.locadora.controller.listing.PessoaJuridicaListing;
import br.unitins.locadora.model.Cidade;
import br.unitins.locadora.model.PessoaJuridica;
import br.unitins.locadora.repository.PessoaJuridicaRepository;


@Named
@ViewScoped
public class PessoaJuridicaController extends Controller<PessoaJuridica> implements Serializable {

	private static final long serialVersionUID = -5014008555974941432L;

	public PessoaJuridicaController() {
		super(new PessoaJuridicaRepository());
	}
	
	@Override
	protected void limparRelacionamentosNaoObrigatorios() {
		if (getEntity().getCidade().getId() == null)
			getEntity().setCidade(null);
	}
	
	@Override
	public PessoaJuridica getEntity() {
		if (entity == null) {
			entity = new PessoaJuridica();
			entity.setCidade(new Cidade());
		}
		
		return entity;
	}
	
	public void abrirPessoaJuridicaListing() {
		PessoaJuridicaListing listing = new PessoaJuridicaListing();
		listing.open();
	}
	
	public void obterPessoaJuridicaListing(SelectEvent<PessoaJuridica> event) {
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