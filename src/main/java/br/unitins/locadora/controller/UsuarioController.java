package br.unitins.locadora.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.controller.listing.PessoaFisicaListing;
import br.unitins.locadora.model.PessoaFisica;
import br.unitins.locadora.model.Usuario;
import br.unitins.locadora.repository.UsuarioRepository;

import br.unitins.locadora.model.Sexo;
import br.unitins.locadora.model.Funcao;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = -3236682773291811713L;
	private InputStream fotoInputStream = null;
	private String confirmarSenha;

	private boolean verificaSenha() {
		if (getEntity().getSenha().equals(getConfirmarSenha())) {
			return true;
		}
		Util.addErrorMessage("As senhas estão diferentes.");
		return false;
	}

	public Sexo[] getListaSexo() {
		return Sexo.values();
	}

	public Funcao[] getListaFuncao() {
		return Funcao.values();
	}

	public UsuarioController() {
		super(new UsuarioRepository());
	}

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
		if (!verificaSenha()) {
			return;
		}
		super.salvarSemLimpar();

		// caso exista uma imagem
		if (getFotoInputStream() != null) {
			// salvando a imagem
			if (!Util.saveImageUsuario(getFotoInputStream(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro ao salvar. Não foi possível salvar a imagem do usuário.");
				return;
			}
		}
		limpar();
	}

	@Override
	public void alterar() {
		if (!verificaSenha()) {
			return;
		}
		super.salvarSemLimpar();

		// caso exista uma imagem
		if (getFotoInputStream() != null) {
			// salvando a imagem
			if (!Util.saveImageUsuario(getFotoInputStream(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro ao salvar. Não foi possível salvar a imagem do usuário.");
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

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
}
