package br.gov.edu.fatec.lab4.loja.categoria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest()
public class CategoriaServiceTest {
	
	Categoria categoria;
	
	Categoria categoriaUpdate;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Before
	public void setUp() throws Exception {
		 categoria = new Categoria();
		 categoria.setNome("Teste");
		 categoriaUpdate = new Categoria();
		 categoria.setNome("updateTeste");
	}

	@Test
	public void testFindById() {
		categoriaService.save(categoria);
		assertTrue(categoria.equals(categoriaService.findById(categoria.getId()).get()));
	}

	@Test
	public void testSave() {
		assertTrue("Deveria ter retornado a categoria"+categoria.getNome(),categoriaService.save(categoria));
	}

	@Test
	public void testRemove() {
		categoriaService.save(categoria);
		categoriaService.remove(categoria);
		assertTrue(categoriaService.findById(categoria.getId())==null);
	}

	@Test
	public void testUpdate() {
		categoriaService.save(categoria);
		assertTrue(categoriaService.update(categoria,categoriaUpdate));
		assertEquals(categoria.getNome(), categoriaService.findById(categoriaUpdate.getId()).get().getNome());
	}

	@Test
	public void testFindAll() {
		categoriaService.save(categoria);
		categoriaService.save(categoriaUpdate);
		assertTrue(categoriaService.findAll().containsAll(Arrays.asList(categoria,categoriaUpdate)));
	}

}
