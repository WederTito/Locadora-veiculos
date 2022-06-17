package br.unitins.locadora.model;

public enum Pagamento {
	DINHEIRO (1, "Dinheiro."),
	PIX (2, "Pix."),
	CARTAO (3, "Cartão de credito.");
	
	private int value;
	private String label;
	
	Pagamento (int value, String label){
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
