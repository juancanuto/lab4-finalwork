package br.gov.edu.fatec.lab4.loja.produto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.gov.edu.fatec.lab4.loja.categoria.Categoria;
import br.gov.edu.fatec.lab4.loja.categoria.CategoriaService;
import br.gov.edu.fatec.lab4.loja.endereco.EnderecoRepository;
import br.gov.edu.fatec.lab4.loja.fornecedor.FornecedorRepository;
import br.gov.edu.fatec.lab4.loja.utils.UtilsTest;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest()
public class ProdutoServiceTest {
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	 
	private Produto produto1;
	
	private Produto produto2;
	
	private Categoria categoria;

	private Produto produtoRetorno;

	private Categoria categoria2;
   
	
	@Before
	public void setUp() throws Exception {
		categoria = UtilsTest.criarCategoria();
		categoriaService.save(categoria);
		Optional<Categoria> cat =categoriaService.findById(categoria.getId());
		categoria = cat!=null?cat.get():null;
		produto1 = UtilsTest.criarProduto();
		produto1.setCategoria(categoria); 
		produtoService.save(produto1);
		
		produto2 = UtilsTest.criarProduto();
		produto2.setModelo("Corsa");
		produto2.setCategoria(categoria); 
		produtoService.save(produto2);
		
		categoria2 = UtilsTest.criarCategoria();
		categoriaService.save(categoria2);
	}
	
	@Test
	public void testFindById() {
		assertTrue(produto1.equals(produtoService.findById(produto1.getId()).get()));
	}

	@Test
	public void testSave() {
		assertTrue("Deveria ter retornado a produto"+produto2.getNome(),produtoService.save(produto2));
	}

	@Test
	public void testRemove() {
		Produto p = UtilsTest.criarProduto();
		p.setCategoria(categoria); 
		produtoService.save(p);
		p = produtoService.remove(p);
		assertFalse(produtoService.findById(p.getId())!=null);
	}

	@Test
	public void testUpdate() {
		Produto produtoUpdate = UtilsTest.criarProduto();
		produtoUpdate.setCategoria(categoria); 
		assertTrue(produtoService.update(produto1,produtoUpdate));
		assertEquals(produtoUpdate, produtoService.findById(produtoUpdate.getId()).get());
	}

	@Test
	public void testFindAll() {
		assertTrue(produtoService.findAll().containsAll(Arrays.asList(produto1,produto2)));
	}
	
	@Test
	public void testVincularCategoria() {
		produtoRetorno = produtoService.vincularCategoria(produto1,categoria2);
		assertEquals(produtoRetorno.getCategoria(),
				produtoService.findById(produtoRetorno.getId()).get().getCategoria());
	}
}
