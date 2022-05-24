package br.unitins.locadora.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.controller.listing.EstadoListing;
import br.unitins.locadora.model.Estado;
import br.unitins.locadora.repository.EstadoRepository;

@Named
@SessionScoped
public class EstadoController extends Controller<Estado> implements Serializable{

	private static final long serialVersionUID = -3236682773291811713L;
	
	
	public EstadoController() {
		super(new EstadoRepository());
	}
	
	@Override
	public Estado getEntity() {
		if (entity == null)
			entity = new Estado();
		return entity;
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent<Estado> event) {
		setEntity(event.getObject());
	}

}
