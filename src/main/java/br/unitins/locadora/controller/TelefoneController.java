package br.unitins.locadora.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.controller.listing.TelefoneListing;
import br.unitins.locadora.model.Telefone;
import br.unitins.locadora.repository.TelefoneRepository;

@Named
@SessionScoped
public class TelefoneController extends Controller<Telefone> implements Serializable{

	private static final long serialVersionUID = -4610553609872419320L;

	public TelefoneController() {
		super(new TelefoneRepository());
	}
	
	@Override
	public Telefone getEntity() {
		if (entity == null)
			entity = new Telefone();
		return entity;
	}
	
	public void abrirTelefoneListing() {
		TelefoneListing listing = new TelefoneListing();
		listing.open();
	}
	
	public void obterTelefoneListing(SelectEvent<Telefone> event) {
		setEntity(event.getObject());
	}

}
