package br.unitins.locadora.model;

public enum Completo {
	SIM (1, "Sim."),
	NAO (2, "N?o, tem observa??es.");
	
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
