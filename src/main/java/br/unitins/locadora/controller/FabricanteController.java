package br.unitins.locadora.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.controller.listing.CategoriaListing;
import br.unitins.locadora.controller.listing.CategoriaListing;
import br.unitins.locadora.controller.listing.FabricanteListing;
import br.unitins.locadora.model.Categoria;
import br.unitins.locadora.model.Cidade;
import br.unitins.locadora.model.Categoria;
import br.unitins.locadora.model.Estado;
import br.unitins.locadora.model.Fabricante;
import br.unitins.locadora.repository.CarroRepository;
import br.unitins.locadora.repository.CategoriaRepository;
import br.unitins.locadora.repository.FabricanteRepository;

@Named
@ViewScoped
public class FabricanteController extends Controller<Fabricante> implements Serializable{

	private static final long serialVersionUID = -3236682773291811713L;
	
	
	public FabricanteController() {
		super(new FabricanteRepository());
	}
	
	@Override
	public Fabricante getEntity() {
		if (entity == null) {
			entity = new Fabricante();
			entity.setCategoria(new Categoria());
		}return entity;
	}
	
	public void abrirFabricanteListing() {
		FabricanteListing listing = new FabricanteListing();
		listing.open();
	}
	
	public void obterFabricanteListing(SelectEvent<Fabricante> event) {
		setEntity(event.getObject());
	}
	
	public void abrirCategoriaListing() {
		CategoriaListing listing = new CategoriaListing();
		listing.open();
	}
	
	public void obterCategoriaListing(SelectEvent<Categoria> event) {
		getEntity().setCategoria(event.getObject());
	}
	
	public List<Categoria> completeCategoria(String filtro) {
		CategoriaRepository repo = new CategoriaRepository();
		try {
			return repo.findByNome(filtro, 4);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Categoria>();
		}
	}

}
