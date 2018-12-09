package br.gov.edu.fatec.lab4.loja.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	
//	@Autowired
//	public ProdutoService produtoService;
//	
//	@RequestMapping(value = "/produtos/", method = RequestMethod.POST)
//	public ResponseEntity<Produto> cadastrarProduto(@PathVariable Produto produto) {
//		produtoService.save(produto);
//		Optional<Produto>p = produtoService.findById(produto.getId());
//		if(p.isPresent()) {
//			return ResponseEntity.status(HttpStatus.CREATED).build();
//		}
//		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
//	}
//	
//	@RequestMapping(name="/produto/{id}", method= RequestMethod.GET)
//	public Produto consultarProdutoPorId(@PathVariable Produto produto) {
//		Optional<Produto>p = produtoService.findById(produto.getId()); 
//		return p.isPresent()?p.get():null;
//	}
//	
//	@RequestMapping(name="/produtos", method= RequestMethod.GET)
//	public List<Produto> consultarTodos() {
//		return produtoService.findAll();
//	}
//	
//	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Produto> removerProduto(@PathVariable Produto produto) {
//		produtoService.remove(produto);
//		Optional<Produto>p = produtoService.findById(produto.getId());
//		if(!p.isPresent()) {
//			return ResponseEntity.status(HttpStatus.OK).build();
//		}
//		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
//	}
}
