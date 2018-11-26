package br.gov.edu.fatec.lab4.loja.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.edu.fatec.lab4.loja.cliente.Cliente;
import br.gov.edu.fatec.lab4.loja.cliente.ClienteRepository;

public class ProdutoService implements ProdutoServiceImpl {

	@Autowired
	public ProdutoRepository produtoRepository;
	
	@Override
	public boolean save(Produto produto) {
		produtoRepository.save(produto);
		return produtoRepository.existsById(produto.getId());
	}

	@Override
	public Produto remove(Produto produto) {
		produtoRepository.delete(produto);
		return produto;
	}

	@Override
	public boolean update(Produto produto, Produto clienteUpdate) {
		Optional<Produto> c = findById(produto.getId());
		if(c.isPresent()) {
			clienteUpdate.setId(c.get().getId());
			return save(clienteUpdate);
		}
		return false;
	}

	@Override
	public Optional<Produto> findById(Integer id) {
		Optional<Produto> cliente = produtoRepository.findById(id);
		return cliente.isPresent()?cliente:null;
	}

	@Override
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
}
