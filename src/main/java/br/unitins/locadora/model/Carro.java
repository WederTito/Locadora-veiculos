package br.unitins.locadora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Carro extends DefaultEntity implements Serializable {
	
	private static final long serialVersionUID = 2771087309688789669L;
	
	@Column(length = 50)
	String marca;
	@Column(length = 50)
	String nome;
	@Column(length = 50)
	String cor;
	@Column(length = 50)
	String chassi;
	@Column(length = 50)
	String placa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
