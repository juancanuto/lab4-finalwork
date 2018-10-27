package br.gov.edu.fatec.lab4.loja.venda;

public enum FormaPagamento {
	À_VISTA(1),À_PRAZO(2), CHEQUE(3), CARTAO_CREDITO(4);
	
	private int cod;
	private FormaPagamento(int cod) {
		this.setCod(cod);
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
}
