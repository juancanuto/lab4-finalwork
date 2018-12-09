package br.gov.edu.fatec.lab4.loja.estoque;

import br.gov.edu.fatec.lab4.loja.generic.crud.IGenericServiceCrud;
import br.gov.edu.fatec.lab4.loja.produto.Produto;

public interface IEstoqueImpl extends IGenericServiceCrud<Estoque, Integer> {
	Estoque findByProduto(Produto produto);
}
