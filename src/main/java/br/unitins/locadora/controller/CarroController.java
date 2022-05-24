package br.unitins.locadora.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.controller.listing.CarroListing;
import br.unitins.locadora.controller.listing.FabricanteListing;
import br.unitins.locadora.repository.CarroRepository;
import br.unitins.locadora.model.Carro;
import br.unitins.locadora.model.Completo;
import br.unitins.locadora.model.Fabricante;
import br.unitins.locadora.model.Sexo;

@Named
@ViewScoped
public class CarroController extends Controller<Carro> implements Serializable {

	private static final long serialVersionUID = -3236682773291811713L;

	public CarroController() {
		super(new CarroRepository());
	}

	@Override
	public Carro getEntity() {
		if (entity == null) {
			entity = new Carro();
			entity.setFabricante(new Fabricante());
		}
		return entity;
	}

	public Completo[] getListaCompleto() {
		return Completo.values();
	}
	
	public void abrirCarroListing() {
		CarroListing listing = new CarroListing();
		listing.open();
	}

	public void obterCarroListing(SelectEvent<Carro> event) {
		setEntity(event.getObject());
	}
	
	public void abrirFabricanteListing() {
		FabricanteListing listing = new FabricanteListing();
		listing.open();
	}
	
	public void obterFabricanteListing(SelectEvent<Fabricante> event) {
		getEntity().setFabricante(event.getObject());
	}

}
