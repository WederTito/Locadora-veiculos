package br.unitins.locadora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.unitins.locadora.model.Sexo;

@Entity
public class Cliente extends DefaultEntity implements Serializable{

	private static final long serialVersionUID = -3361336513357994868L;

	@Column(length = 100)
	private String nome;
	
	@Column(length = 14)
	private String cpf;
	
	@Column(length = 80)
	private String funcao;

	@Column(length = 80)
	private String email;
	
	@Column(length = 80)
	private String cnh;
	

	private Sexo sexo;
	
	
	
	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	

}
