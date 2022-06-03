package br.unitins.locadora.controller;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.locadora.application.RepositoryException;
import br.unitins.locadora.application.Util;
import br.unitins.locadora.model.Usuario;
import br.unitins.locadora.repository.UsuarioRepository;
import br.unitins.locadora.model.RecuperarSenha;
import br.unitins.locadora.repository.RecuperaSenhaRepository;



@Named
@ViewScoped
public class RecuperarSenhaController implements Serializable{
	private static final long serialVersionUID = 1624637313308470607L;
	
	private String codigo;
	private String senha;

	public void alterarSenha() throws RepositoryException {
		UsuarioRepository repoUsu = new UsuarioRepository();
		RecuperaSenhaRepository repo = new RecuperaSenhaRepository();

		RecuperarSenha obj = null;
		try {
			obj = repo.findByCodigo(getCodigo());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (obj == null || obj.getDataLimite().isBefore(LocalDateTime.now()) || obj.getUtilizado() == true) {

			Util.addErrorMessage("Esse código é invalido ou expirou.");
			limpar();
		} else {
			Usuario usu = obj.getUsuario();
			usu.setSenha(getSenha());
			obj.setUtilizado(true);
			repoUsu.adicionar(usu);
			repo.adicionar(obj);
			Util.addInfoMessage("Senha alterada com sucesso.");
			limpar();
		}

	}

	public void limpar() {
		setSenha(null);
		setCodigo(null);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}