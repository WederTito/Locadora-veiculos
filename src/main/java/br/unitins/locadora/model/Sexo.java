package br.unitins.locadora.model;

public enum Sexo {
	MASCULINO (1, "Masculino"),
	FEMININO (2, "Feminino"),
	OUTRO (3, "Outro");
	
	private int value;
	private String label;
	
	Sexo (int value, String label){
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
