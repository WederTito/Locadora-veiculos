package br.unitins.locadora.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import br.unitins.locadora.application.Util;
import br.unitins.locadora.controller.listing.CarroListing;
import br.unitins.locadora.controller.listing.FabricanteListing;
import br.unitins.locadora.repository.CarroRepository;
import br.unitins.locadora.model.Carro;
import br.unitins.locadora.model.Completo;
import br.unitins.locadora.model.Fabricante;
import br.unitins.locadora.model.Motor;
import br.unitins.locadora.model.Sexo;

@Named
@ViewScoped
public class CarroController extends Controller<Carro> implements Serializable {

	private static final long serialVersionUID = -3236682773291811713L;
	private InputStream fotoInputStream = null;

	public void upload(FileUploadEvent event) {
		UploadedFile uploadFile = event.getFile();
		System.out.println("nome arquivo: " + uploadFile.getFileName());
		System.out.println("tipo: " + uploadFile.getContentType());
		System.out.println("tamanho: " + uploadFile.getSize());

		if (uploadFile.getContentType().equals("image/png")) {
			try {
				fotoInputStream = uploadFile.getInputStream();
				System.out.println("inputStream: " + uploadFile.getInputStream().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Util.addInfoMessage("Upload realizado com sucesso.");
		} else {
			Util.addErrorMessage("O tipo da image deve ser png.");
		}

	}
	
	@Override
	public void incluir() {
		super.salvarSemLimpar();
			
		// caso exista uma imagem
		if (getFotoInputStream() != null) {
			// salvando a imagem
			if (! Util.saveImageCarro(getFotoInputStream(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro ao salvar. Não foi possível salvar a imagem do carro.");
				return;
			}
		}
		limpar();
	}
	
	@Override
	public void alterar() {
		super.salvarSemLimpar();
			
		// caso exista uma imagem
		if (getFotoInputStream() != null) {
			// salvando a imagem
			if (! Util.saveImageCarro(getFotoInputStream(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro ao salvar. Não foi possível salvar a imagem do carro.");
				return;
			}
		}
		limpar();
	}
	
	
	public InputStream getFotoInputStream() {
		return fotoInputStream;
	}

	public void setFotoInputStream(InputStream fotoInputStream) {
		this.fotoInputStream = fotoInputStream;
	}
	
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
	
	public Motor[] getListaMotor() {
		return Motor.values();
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
