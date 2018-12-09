package br.gov.edu.fatec.lab4.loja.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.edu.fatec.lab4.loja.categoria.Categoria;
import br.gov.edu.fatec.lab4.loja.fornecedor.ItemCompraRepository;

@Service
public class ProdutoService implements ProdutoServiceImpl {

	@Autowired
	public ProdutoRepository produtoRepository;
	
	@Autowired
	public ItemCompraRepository ItemCompraRepository;
	
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
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.isPresent()?produto:null;
	}

	@Override
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto vincularCategoria(Produto produto,Categoria categoria) {
		produto.setCategoria(categoria);
		save(produto);
		Optional<Produto> p = findById(produto.getId());
		produto = p!=null?p.get():null;
		return produto;
	}
	
	public Integer recuperarEstoqueMinimo(Produto produto) {
		return produto.getEstoque().getQtdMinima();
	}
}
