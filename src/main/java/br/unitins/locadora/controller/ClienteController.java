package br.unitins.locadora.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.controller.listing.ClienteListing;
import br.unitins.locadora.controller.listing.PessoaFisicaListing;
import br.unitins.locadora.repository.ClienteRepository;
import br.unitins.locadora.model.Sexo;
import br.unitins.locadora.model.Cliente;
import br.unitins.locadora.model.PessoaFisica;

@Named
@SessionScoped
public class ClienteController extends Controller<Cliente> implements Serializable{
	

	private static final long serialVersionUID = -4753157136618586534L;

	public ClienteController() {
		super(new ClienteRepository());
	}
	
	
	public Sexo[] getListaSexo() {
		return Sexo.values();
	}

	@Override
	public Cliente getEntity() {
		if (entity == null) {
			entity = new Cliente();
			entity.setPessoaFisica(new PessoaFisica());
		}
		return entity;
	}
	
	public void abrirPessoaFisicaListing() {
		PessoaFisicaListing listing = new PessoaFisicaListing();
		listing.open();
	}
	
	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
		PessoaFisica pf = event.getObject();
		ClienteRepository repo = new ClienteRepository();
		Cliente usuario = null;
		try {
			usuario = repo.findByIdPessoaFisica(pf.getId());
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		if (usuario != null) 
			setEntity(usuario);
		else
			getEntity().setPessoaFisica(pf);	
	}
}
