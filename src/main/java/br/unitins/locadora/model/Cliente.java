package br.unitins.locadora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Cliente extends DefaultEntity implements Serializable{

	private static final long serialVersionUID = -3361336513357994868L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true)
	private PessoaFisica pessoaFisica;
	
	@Column(length = 100)
	private String nome;
	
	@Column(length = 80)
	private String funcao;

	@Column(length = 80)
	private String email;

	private Sexo sexo;
	

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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	
}
