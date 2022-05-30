package br.unitins.locadora.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.controller.listing.EnderecoListing;
import br.unitins.locadora.controller.listing.PessoaJuridicaListing;
import br.unitins.locadora.model.Endereco;
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
		if (getEntity().getEndereco().getId() == null)
			getEntity().setEndereco(null);
	}
	
	@Override
	public PessoaJuridica getEntity() {
		if (entity == null) {
			entity = new PessoaJuridica();
			entity.setEndereco(new Endereco());
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
	
	public void abrirEnderecoListing() {
		EnderecoListing listing = new EnderecoListing();
		listing.open();
	}
	
	public void obterEnderecoListing(SelectEvent<Endereco> event) {
		getEntity().setEndereco(event.getObject());
	}
}