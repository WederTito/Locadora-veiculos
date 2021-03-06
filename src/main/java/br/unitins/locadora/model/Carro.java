package br.unitins.locadora.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Carro extends DefaultEntity implements Serializable {
	
	private static final long serialVersionUID = -7157398933971531440L;
	
	//@NotEmpty(message = "Campo modelo n?o pode estar vazio!")
	private String nome;
	//@NotEmpty(message = "Campo cor n?o pode estar vazio!")
	private String cor;
	//@NotEmpty(message = "Campo chassi n?o pode estar vazio!")
	private String chassi;
	//@NotEmpty(message = "Campo placa n?o pode estar vazio!")
	private String placa;
	//@NotEmpty(message = "Campo obs n?o pode estar vazio!")
	private String obs;
	
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
