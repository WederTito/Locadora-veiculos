package br.unitins.locadora.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.controller.listing.CarroListing;
import br.unitins.locadora.controller.listing.PessoaFisicaListing;
import br.unitins.locadora.controller.listing.LocacaoListing;
import br.unitins.locadora.model.Carro;
import br.unitins.locadora.model.Funcao;
import br.unitins.locadora.model.PessoaFisica;
import br.unitins.locadora.model.PessoaFisica;
import br.unitins.locadora.model.Carro;
import br.unitins.locadora.model.Locacao;
import br.unitins.locadora.model.Pagamento;
import br.unitins.locadora.repository.CarroRepository;
import br.unitins.locadora.repository.PessoaFisicaRepository;
import br.unitins.locadora.repository.LocacaoRepository;

@Named
@ViewScoped
public class LocacaoController extends Controller<Locacao> implements Serializable {

	private static final long serialVersionUID = -4610553609872419320L;

	public LocacaoController() {
		super(new LocacaoRepository());
	}

	@Override
	public Locacao getEntity() {
		if (entity == null) {
			entity = new Locacao();
			entity.setCarro(new Carro());
			entity.setPessoaFisica(new PessoaFisica());
		}
		return entity;
	}

	public void abrirLocacaoListing() {
		LocacaoListing listing = new LocacaoListing();
		listing.open();
	}
	
	public Pagamento[] getListaPagamento() {
		return Pagamento.values();
	}

	public void obterLocacaoListing(SelectEvent<Locacao> event) {
		setEntity(event.getObject());
	}
	public void abrirCarroListing() {
		CarroListing listing = new CarroListing();
		listing.open();
	}
	
	public void obterCarroListing(SelectEvent<Carro> event) {
		getEntity().setCarro(event.getObject());
	}
	
	public List<Carro> completeCarro(String filtro) {
		CarroRepository repo = new CarroRepository();
		try {
			return repo.findByNome(filtro, 4);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Carro>();
		}
	}
	
	public void abrirPessoaFisicaListing() {
		PessoaFisicaListing listing = new PessoaFisicaListing();
		listing.open();
	}
	
	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
		getEntity().setPessoaFisica(event.getObject());
	}
	
	public List<PessoaFisica> completePessoaFisica(String filtro) {
		PessoaFisicaRepository repo = new PessoaFisicaRepository();
		try {
			return repo.findByNome(filtro, 4);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<PessoaFisica>();
		}
	}
}
