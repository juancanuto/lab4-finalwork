package br.gov.edu.fatec.lab4.loja.estoque;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.edu.fatec.lab4.loja.estoque.Estoque;
import br.gov.edu.fatec.lab4.loja.estoque.EstoqueRepository;
import br.gov.edu.fatec.lab4.loja.produto.Produto;

public class EstoqueService implements IEstoqueImpl{
	
	@Autowired
	public EstoqueRepository estoqueRepository;
	
	@Override
	public boolean save(Estoque estoque) {
		estoqueRepository.save(estoque);
		return estoqueRepository.findById(estoque.getId()).isPresent();
	}

	@Override
	public Estoque remove(Estoque estoque) {
		estoqueRepository.delete(estoque);
		return estoque;
	}

	@Override
	public boolean update(Estoque estoque, Estoque estoqueUpdate) {
		Optional<Estoque> c = findById(estoque.getId());
		if(c.isPresent()) {
			estoqueUpdate.setId(c.get().getId());
			return save(estoqueUpdate);
		}
		return false;
	}

	@Override
	public Optional<Estoque> findById(Integer id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		return estoque.isPresent()?estoque:null;
	}

	@Override
	public List<Estoque> findAll() {
		return estoqueRepository.findAll();
	}

	@Override
	public Estoque findByProduto(Produto produto) {
		return estoqueRepository.findByProduto(produto);
	}

}
