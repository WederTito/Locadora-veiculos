package br.unitins.locadora.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.controller.listing.PessoaFisicaListing;
import br.unitins.locadora.model.Funcao;
import br.unitins.locadora.model.PessoaFisica;
import br.unitins.locadora.repository.UsuarioRepository;
import br.unitins.locadora.model.Sexo;
import br.unitins.locadora.model.Usuario;

@Named
@SessionScoped
public class UsuarioController extends Controller<Usuario> implements Serializable{

	private static final long serialVersionUID = -3236682773291811713L;
	
	
	public UsuarioController() {
		super(new UsuarioRepository());
	}
	
	
	public Sexo[] getListaSexo() {
		return Sexo.values();
	}
	
	public Funcao[] getListaFuncao() {
		return Funcao.values();
	}

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
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
		UsuarioRepository repo = new UsuarioRepository();
		Usuario usuario = null;
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
