package br.unitins.locadora.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Carro extends DefaultEntity {
	
	String nome;
	String cor;
	String chassi;
	String placa;
	String obs;
	
	@ManyToOne
	private Fabricante fabricante;
	private Completo completo;
	private Motor motor;
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Completo getCompleto() {
		return completo;
	}

	public void setCompleto(Completo completo) {
		this.completo = completo;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

}
