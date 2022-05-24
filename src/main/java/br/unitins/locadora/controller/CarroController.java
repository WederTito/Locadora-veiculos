package br.unitins.locadora.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.controller.listing.CarroListing;
import br.unitins.locadora.repository.CarroRepository;
import br.unitins.locadora.model.Sexo;
import br.unitins.locadora.model.Carro;

@Named
@SessionScoped
public class CarroController extends Controller<Carro> implements Serializable {

	private static final long serialVersionUID = -3236682773291811713L;

	public CarroController() {
		super(new CarroRepository());
	}

	public Sexo[] getListaSexo() {
		return Sexo.values();
	}

	@Override
	public Carro getEntity() {
		if (entity == null)
			entity = new Carro();
		return entity;
	}

	public void abrirCarroListing() {
		CarroListing listing = new CarroListing();
		listing.open();
	}

	public void obterCarroListing(SelectEvent<Carro> event) {
		setEntity(event.getObject());
	}

}
