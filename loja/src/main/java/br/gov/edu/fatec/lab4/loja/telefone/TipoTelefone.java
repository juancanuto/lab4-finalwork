package br.gov.edu.fatec.lab4.loja.telefone;

public enum TipoTelefone {
	RESIDENCIAL(1), CELULAR(2), COMERCIAL(3);
	
	private int tipo;
	TipoTelefone(int tipo) {
		this.tipo = tipo;
	}
	
	public int getTipo() {
		return tipo;
	}
}