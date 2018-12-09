package br.gov.edu.fatec.lab4.loja.enuns;

public enum TipoCor {
	VERDE(1,"Verde"), AMARELO(2,"Amarelo"), AZUL(3,"Azul"), BRANCO(4,"Branco"), PRETO(5,"Preto");
	
	private Integer codigo;
	private String cor;
	
	
	private TipoCor(Integer codigo, String cor) {
		this.codigo = codigo;
		this.cor = cor;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
}
