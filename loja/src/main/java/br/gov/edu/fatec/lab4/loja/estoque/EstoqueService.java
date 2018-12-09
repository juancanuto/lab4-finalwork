package br.gov.edu.fatec.lab4.loja.estoque;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.edu.fatec.lab4.loja.produto.Produto;
import br.gov.edu.fatec.lab4.loja.produto.ProdutoService;
@Service
public class EstoqueService implements IEstoqueImpl{
	
	@Autowired
	public EstoqueRepository estoqueRepository;
	@Autowired
	ProdutoService produtoService;
	
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
	
	public void emitirRelatorioPorCategoria(Produto produto) {
		Produto produto1 = estoqueRepository.findByProduto(produto).getProduto();
		System.out.println(produto.toString());
	}
	
	
	public void emitirRelatorioRelatorioTodosProdutos() {
		List<Estoque> estoques = estoqueRepository.findAll();
		for (Estoque estoque : estoques) {
			Produto produto1 = estoque.getProduto();
			System.out.println(
					"Produto: "+produto1.getNome()
					+" "+produto1.getMarca()
					+""+produto1.getModelo()
					+""+produto1.getCor()
					+""+produto1.getObservacao()
					+""+produto1.getTamanho()
					+""+produto1.getValor()
					+""+produto1.getCategoria()
					+""+produto1.getDataFabricacao());
		}
	}
	
	public boolean verificarEstoqueMinimo(Produto produto,Integer parametroProcurado) {
		return produtoService.recuperarEstoqueMinimo(produto) < parametroProcurado;
	}

}
