package br.unitins.locadora.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.controller.listing.CategoriaListing;
import br.unitins.locadora.model.Categoria;
import br.unitins.locadora.repository.CategoriaRepository;

@Named
@SessionScoped
public class CategoriaController extends Controller<Categoria> implements Serializable{

	private static final long serialVersionUID = -3637318078178596778L;

	public CategoriaController() {
		super(new CategoriaRepository());
	}
	
	@Override
	public Categoria getEntity() {
		if (entity == null)
			entity = new Categoria();
		return entity;
	}
	
	public void abrirCategoriaListing() {
		CategoriaListing listing = new CategoriaListing();
		listing.open();
	}
	
	public void obterCategoriaListing(SelectEvent<Categoria> event) {
		setEntity(event.getObject());
	}

}
