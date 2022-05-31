package br.unitins.locadora.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.repository.EstadoRepository;
import br.unitins.locadora.controller.listing.CidadeListing;
import br.unitins.locadora.controller.listing.EstadoListing;
import br.unitins.locadora.model.Cidade;
import br.unitins.locadora.model.Estado;
import br.unitins.locadora.repository.CidadeRepository;

@Named
@ViewScoped
public class CidadeController extends Controller<Cidade> implements Serializable {

	private static final long serialVersionUID = -541052669788444958L;

	public CidadeController() {
		super(new CidadeRepository());
	}
	
	@Override
	public Cidade getEntity() {
		if (entity == null) {
			entity = new Cidade();
			entity.setEstado(new Estado());
		}
		return entity;
	}
	
	public void abrirCidadeListing() {
		CidadeListing listing = new CidadeListing();
		listing.open();
	}
	
	public void obterCidadeListing(SelectEvent<Cidade> event) {
		setEntity(event.getObject());
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent<Estado> event) {
		getEntity().setEstado(event.getObject());
	}
	
	public List<Estado> completeEstado(String filtro) {
		EstadoRepository repo = new EstadoRepository();
		try {
			return repo.findByNome(filtro, 4);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Estado>();
		}
	}
}