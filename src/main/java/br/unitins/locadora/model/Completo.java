package br.unitins.locadora.model;

public enum Completo {
	ADMINISTRADOR (1, "Sim, Carro Completo."),
	FUNCIONARIO (2, "Não, tem observações.");
	
	private int value;
	private String label;
	
	Completo (int value, String label){
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
