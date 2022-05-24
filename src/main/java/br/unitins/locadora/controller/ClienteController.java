package br.unitins.locadora.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.controller.listing.ClienteListing;
import br.unitins.locadora.repository.ClienteRepository;
import br.unitins.locadora.model.Sexo;
import br.unitins.locadora.model.Cliente;

@Named
@SessionScoped
public class ClienteController extends Controller<Cliente> implements Serializable{

	private static final long serialVersionUID = -3236682773291811713L;
	
	
	public ClienteController() {
		super(new ClienteRepository());
	}
	
	
	public Sexo[] getListaSexo() {
		return Sexo.values();
	}

	@Override
	public Cliente getEntity() {
		if (entity == null)
			entity = new Cliente();
		return entity;
	}

	public void abrirClienteListing() {
		ClienteListing listing = new ClienteListing();
		listing.open();
	}
	
	public void obterClienteListing(SelectEvent<Cliente> event) {
		setEntity(event.getObject());
	}
	

}
