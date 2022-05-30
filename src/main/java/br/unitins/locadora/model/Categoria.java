package br.unitins.locadora.model;

import javax.persistence.Entity;

@Entity
public class Categoria extends DefaultEntity {
	private String nome;
	private Double valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
