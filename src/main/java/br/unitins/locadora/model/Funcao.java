package br.unitins.locadora.model;

import java.util.ArrayList;
import java.util.List;

import br.unitins.locadora.model.Funcao;

public enum Funcao {
	ADMINISTRADOR (1, "Administrador"),
	FUNCIONARIO (2, "Funcionario");
	
	private int id;
	private String label;
	private List<String> paginasComPermissao;
	
	Funcao(int id, String label) {
		this.id = id;
		this.label = label;
		paginasComPermissao = new ArrayList<String>();
		if (id == 1) {
			paginasComPermissao.add("/Locadora/faces/admin/cidade.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/cidadelisting.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/cliente.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/clientelisting.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/estado.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/carro.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/carrolisting.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/fabricante.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/pessoafisica.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/pessoafisicalisting.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/pessoajuridica.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/pessoajuridicalisting.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/usuario.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/usuariolisting.xhtml");
		} else {
			paginasComPermissao.add("/Locadora/faces/admin/cidade.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/estado.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/cidadelisting.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/carrolisting.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/estadolisting.xhtml");
			paginasComPermissao.add("/Locadora/faces/admin/cidadelistingsql.xhtml");
		}
		
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public List<String> getPaginasComPermissao() {
		return paginasComPermissao;
	}
	
	public static Funcao valueOf(int id) {
		for (Funcao perfil : Funcao.values()) {
			if (perfil.getId() == id)
				return perfil;
		}
		return null;
	}

}