package br.gov.edu.fatec.lab4.loja.estoque;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.edu.fatec.lab4.loja.produto.Produto;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{
	Estoque findByProduto(Produto produto);
}
