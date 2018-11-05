package br.gov.edu.fatec.lab4.loja.categoria;

public interface CategoriaServiceImpl {
	public Categoria findById(Integer id);
	public boolean salvar(Categoria categoria);
}
