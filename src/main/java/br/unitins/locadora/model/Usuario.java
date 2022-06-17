package br.unitins.locadora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;


@Entity
public class Usuario extends DefaultEntity implements Serializable {

	private static final long serialVersionUID = -3361336513357994868L;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true)
	private PessoaFisica pessoaFisica;
	
	@Column(length = 100)
	private String nome;

	private Funcao funcao;

	@Column(length = 80)
	//@NotEmpty(message = "Campo login não pode estar vazio!")
	private String login;

	@Column(length = 256)
	//@NotEmpty(message = "Campo senha não pode estar vazio!")
	private String senha;

	private Sexo sexo;
	
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
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

}
