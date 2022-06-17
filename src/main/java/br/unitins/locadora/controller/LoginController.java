package br.unitins.locadora.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Session;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.model.Usuario;
import br.unitins.locadora.repository.UsuarioRepository;

@Named
@RequestScoped
public class LoginController {

	private Usuario usuario;
	private String login = "";
	private String senha = "";
	private UsuarioRepository  usuarioRepository;
	
	public void entrar() {
		UsuarioRepository repo = new UsuarioRepository();
		Usuario usuarioLogado = repo.getUsuario(getUsuario().getLogin(), Util.hash(getUsuario().getSenha()));
		try {
			usuarioLogado = repo.validarLogin(getUsuario());
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		if (usuarioLogado != null) {
			FacesContext.getCurrentInstance()
			.getExternalContext()
			.getSessionMap()
			.put("usuarioLogado", usuarioLogado);
			
			Util.redirect("locacaolisting.xhtml");
		}
		Util.addErrorMessage("Login ou senha inválido.");

	}

	public void limpar() {
		usuario = null;
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioRepository getUsuarioRepository() {
		if(usuarioRepository == null) {
			usuarioRepository = new UsuarioRepository();
		}
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	

}