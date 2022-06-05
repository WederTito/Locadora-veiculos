package br.unitins.locadora.model;

import java.util.ArrayList;
import java.util.List;

public enum Funcao {
	ADMINISTRADOR (1, "Administrador"),
	FUNCIONARIO (2, "Funcionario");
	
	private Integer id;
	private String label;
	private List<String> paginasComPermissao;
	
	Funcao(Integer id, String label) {
		this.id = id;
		this.label = label;
		paginasComPermissao = new ArrayList<String>();
		
		// acesso para todos os usuarios
		paginasComPermissao.add("/locadora/estado.xhtml");
		paginasComPermissao.add("/locadora/estadolisting.xhtml");
		paginasComPermissao.add("/locadora/estadolistingsql.xhtml");
		
		if (id.equals(1)) { // professor
			paginasComPermissao.add("/locadora/cidade.xhtml");
			paginasComPermissao.add("/locadora/cidadelistingsql.xhtml");
		} else if (id.equals(2)) { // adm
			paginasComPermissao.add("/locadora/cidade.xhtml");
			paginasComPermissao.add("/locadora/cidadelistingsql.xhtml");
			paginasComPermissao.add("/locadora/usuario.xhtml");
			paginasComPermissao.add("/locadora/usuariolisting.xhtml");
			paginasComPermissao.add("/locadora/pessoafisica.xhtml");
			paginasComPermissao.add("/locadora/pessoafisicalisting.xhtml");
			paginasComPermissao.add("/locadora/pessoajuridica.xhtml");
			paginasComPermissao.add("/locadora/pessoajuridicalisting.xhtml");
		}
	}
	
	public List<String> getPaginasComPermissao() {
		return paginasComPermissao;
	}
	
	public static Funcao valueOf(Integer id) {
		if (id == null)
			return null;
		for (Funcao funcao : Funcao.values()) {
			if (funcao.getId().equals(id))
				return funcao;
		}
		return null;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Integer getId() {
		return id;
	}
}
