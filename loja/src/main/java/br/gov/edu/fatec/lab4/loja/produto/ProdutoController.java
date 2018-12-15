package br.gov.edu.fatec.lab4.loja.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@ComponentScan()
public class ProdutoController {
	
//
//	private final ProdutoService produtoService;
//	
//	@PostMapping(value = "/produto")
//	public ResponseEntity<Produto> cadastrarProduto(@PathVariable Produto produto) {
//		produtoService.save(produto);
//		Optional<Produto>p = produtoService.findById(produto.getId());
//		if(p.isPresent()) {
//			return ResponseEntity.status(HttpStatus.CREATED).build();
//		}
//		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
//	}
//	
//	@GetMapping(name="/produto/{id}")
//	public Produto consultarProdutoPorId(@PathVariable int id) {
//		Optional<Produto>p = produtoService.findById(id); 
//		return p.isPresent()?p.get():null;
//	}
//	
//	@GetMapping(name="/produtos")
//	public List<Produto> consultarTodos() {
//		return produtoService.findAll();
//	}
//	
//	@DeleteMapping(value = "/produto/{id}")
//	public void removerProduto(@PathVariable int idProduto) {
//		Optional<Produto> p = produtoService.findById(idProduto);
//		if(!p.isPresent()) {
//			produtoService.remove(p.get());
//		}
//	}
}
