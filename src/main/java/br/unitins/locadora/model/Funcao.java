package br.unitins.locadora.model;

public enum Funcao {
	ADMINISTRADOR (1, "Administrador"),
	FUNCIONARIO (2, "Funcionario");
	
	private int value;
	private String label;
	
	Funcao (int value, String label){
		this.value = value;
		this.label = label;
	}
	public int getValue() {
		return value;
	}
	public String getLabel() {
		return label;
	}
}
