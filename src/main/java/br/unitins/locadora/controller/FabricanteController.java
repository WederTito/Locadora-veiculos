package br.unitins.locadora.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.controller.listing.FabricanteListing;
import br.unitins.locadora.model.Fabricante;
import br.unitins.locadora.repository.FabricanteRepository;

@Named
@SessionScoped
public class FabricanteController extends Controller<Fabricante> implements Serializable{

	private static final long serialVersionUID = -3236682773291811713L;
	
	
	public FabricanteController() {
		super(new FabricanteRepository());
	}
	
	@Override
	public Fabricante getEntity() {
		if (entity == null)
			entity = new Fabricante();
		return entity;
	}
	
	public void abrirFabricanteListing() {
		FabricanteListing listing = new FabricanteListing();
		listing.open();
	}
	
	public void obterFabricanteListing(SelectEvent<Fabricante> event) {
		setEntity(event.getObject());
	}

}
