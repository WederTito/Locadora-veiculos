package br.unitins.locadora.model;

public enum Motor {
	ALCOOL (1, "Alcool."),
	GASOLINA (2, "Gasolina."),
	FLEX (3, "Flex."),
	DIESEL (4, "Diesel.");
	
	private int value;
	private String label;
	
	Motor (int value, String label){
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
