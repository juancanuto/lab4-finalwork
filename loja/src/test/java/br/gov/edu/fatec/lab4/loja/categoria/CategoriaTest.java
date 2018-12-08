package br.gov.edu.fatec.lab4.loja.categoria;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaTest {
	@Autowired
	CategoriaRepository cr;

	private Categoria categoria;
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSalvarCategoria() {	
		Categoria categoria = new Categoria();
		categoria.setNome("Eletrônicos");
		cr.saveAndFlush(categoria);
		Categoria c = cr.findById(categoria.getId()).get();
	}

//	@Test
//	public void testCategoria() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testBuilder() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetNome() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetNome() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEqualsObject() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCanEqual() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToString() {
//		fail("Not yet implemented");
//	}

}
