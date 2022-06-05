package br.unitins.locadora.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.Session;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.model.Usuario;

@Named
@ViewScoped
public class TemplateController implements Serializable {

	private static final long serialVersionUID = 674207771972213340L;
	private Usuario usuarioLogado;
	
	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) 
			usuarioLogado = (Usuario) Session.getInstance().get("usuarioLogado");
		return usuarioLogado;
	}
	
	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Util.redirect("login2.xhtml");
	}
}
