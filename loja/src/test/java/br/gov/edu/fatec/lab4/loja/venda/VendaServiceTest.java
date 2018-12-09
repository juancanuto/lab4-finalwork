package br.gov.edu.fatec.lab4.loja.venda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.gov.edu.fatec.lab4.loja.Pessoa;
import br.gov.edu.fatec.lab4.loja.categoria.Categoria;
import br.gov.edu.fatec.lab4.loja.categoria.CategoriaService;
import br.gov.edu.fatec.lab4.loja.cliente.Cliente;
import br.gov.edu.fatec.lab4.loja.cliente.ClienteRepository;
import br.gov.edu.fatec.lab4.loja.endereco.Endereco;
import br.gov.edu.fatec.lab4.loja.endereco.EnderecoRepository;
import br.gov.edu.fatec.lab4.loja.funcionario.Funcionario;
import br.gov.edu.fatec.lab4.loja.funcionario.FuncionarioService;
import br.gov.edu.fatec.lab4.loja.produto.Produto;
import br.gov.edu.fatec.lab4.loja.produto.ProdutoService;
import br.gov.edu.fatec.lab4.loja.usuario.Usuario;
import br.gov.edu.fatec.lab4.loja.usuario.UsuarioService;
import br.gov.edu.fatec.lab4.loja.utils.UtilsTest;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest()
public class VendaServiceTest {

	@Autowired
	private VendaService vendaService;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	VendaRepository vendaRepository;
	
	@Autowired
	ItemVendaRepository itemVendaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	private Venda venda2;

	private Cliente cliente;

	private Funcionario funcionario;

	private Usuario usuario;

	private List<ItemVenda> itensVenda;

	private ItemVendaPK ItemVendaPK;
	
	private Produto produto1;
	
	private Categoria categoria;

	private Produto produto2;

	private Produto produto3;

	private Venda venda1;
	
	private ItemVendaPK itemVendaPK;	
	
	private ItemVendaPK itemVendaPK2;

	private ItemVendaPK itemVendaPK3;

	private ItemVenda itemVenda1;

	private ItemVenda itemVenda2;

	private ItemVenda itemVenda3;

	private ItemVendaPK itemVendaPK4;

	private ItemVendaPK itemVendaPK5;

	private ItemVendaPK itemVendaPK6;

	private ItemVenda itemVenda4;

	private ItemVenda itemVenda5;

	private ItemVenda itemVenda6;

	private Endereco endereco;

	private Endereco endereco2;

	private Pessoa pessoa;


	@Before
	public void setUp() throws Exception {
		//CRIAÇÃO DE PRODUTO
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
		
		produto3 = UtilsTest.criarProduto();
		produto3.setModelo("Monza");
		produto3.setCategoria(categoria); 
		produtoService.save(produto3);
		
		endereco = UtilsTest.criarEndereco();
		endereco = enderecoRepository.save(endereco);
		
		cliente = UtilsTest.criarCliente(null,"Alberto Roberto",789456123,665268791,endereco);
		clienteRepository.save(cliente);
		
		usuario = UtilsTest.criarUsuario("Isabella", "123");
		usuarioService.save(usuario);
		
		endereco2 = UtilsTest.criarEndereco();
		endereco2 = enderecoRepository.save(endereco2);
		
		funcionario = UtilsTest.criarFuncionario(usuario, "Fernando", 145262512, 336955781, endereco2);
		funcionarioService.save(funcionario);
		
		//CRIAÇÃO DE VENDA 1
		venda1 = UtilsTest.criarVenda(cliente, funcionario);
		vendaRepository.save(venda1);
		
		itemVendaPK = UtilsTest.criarItemVendaPK(produto1,venda1);
		itemVendaPK2 = UtilsTest.criarItemVendaPK(produto2,venda1);
		itemVendaPK3 = UtilsTest.criarItemVendaPK(produto3,venda1);
		
		itemVenda1 = UtilsTest.criarItemVenda(itemVendaPK);
		itemVenda2 = UtilsTest.criarItemVenda(itemVendaPK2);
		itemVenda3 = UtilsTest.criarItemVenda(itemVendaPK3);
		
		itemVendaRepository.save(itemVenda1);
		itemVendaRepository.save(itemVenda2);
		itemVendaRepository.save(itemVenda3);
		itensVenda = Arrays.asList(
				itemVenda1,itemVenda2,itemVenda3
				);
		venda1.setItensVenda(itensVenda);
		
		
		//CRIAÇÃO DE VENDA 2
		venda2 = UtilsTest.criarVenda(cliente, funcionario);
		vendaRepository.save(venda2);
		
		itemVendaPK4 = UtilsTest.criarItemVendaPK(produto1,venda2);
		itemVendaPK5 = UtilsTest.criarItemVendaPK(produto2,venda2);
		itemVendaPK6 = UtilsTest.criarItemVendaPK(produto3,venda2);
		
		itemVenda4 = UtilsTest.criarItemVenda(itemVendaPK4);
		itemVenda5 = UtilsTest.criarItemVenda(itemVendaPK5);
		itemVenda6 = UtilsTest.criarItemVenda(itemVendaPK6);
		
		itemVendaRepository.save(itemVenda4);
		itemVendaRepository.save(itemVenda5);
		itemVendaRepository.save(itemVenda6);
		itensVenda = Arrays.asList(
				itemVenda4,itemVenda5,itemVenda6
				);
		venda2.setItensVenda(itensVenda);
	}
	
	@Test
	public void testSave() {
		Venda vendaSalvar1 = UtilsTest.criarVenda(cliente, funcionario);
		vendaRepository.save(vendaSalvar1);
		
		ItemVendaPK itemVendaSalvarPK = UtilsTest.criarItemVendaPK(produto1,venda1);
		ItemVendaPK itemVendaSalvarPK2 = UtilsTest.criarItemVendaPK(produto2,venda1);
		ItemVendaPK itemVendaSalvarPK3 = UtilsTest.criarItemVendaPK(produto3,venda1);
		
		ItemVenda itemVendaSalvar1 = UtilsTest.criarItemVenda(itemVendaSalvarPK);
		ItemVenda itemVendaSalvar2 = UtilsTest.criarItemVenda(itemVendaSalvarPK2);
		ItemVenda itemVendaSalvar3 = UtilsTest.criarItemVenda(itemVendaSalvarPK3);
		
		itemVendaRepository.save(itemVendaSalvar1);
		itemVendaRepository.save(itemVendaSalvar2);
		itemVendaRepository.save(itemVendaSalvar3);
		itensVenda = Arrays.asList(
				itemVendaSalvar1,itemVendaSalvar2,itemVendaSalvar3
				);
		vendaSalvar1.setItensVenda(itensVenda);
		assertTrue("Deveria ter retornado a venda"+vendaSalvar1,vendaService.save(vendaSalvar1));
	}

	@Test
	public void testRemove() {
		Venda vendaRemov2 = UtilsTest.criarVenda(cliente,funcionario);
		vendaRepository.save(vendaRemov2);
		
		/*
		 * CRIAÇÃO ITEM VENDA_PK CHAVE PRIMARIA DE ITEM VENDA
		 * COM A ENTIDADE 'PRODUTO' E ENTIDADE 'VENDA'
		 */
		ItemVendaPK itemVendaRemovPK = UtilsTest.criarItemVendaPK(produto1,venda2);
		ItemVendaPK itemVendaRemovPK2 = UtilsTest.criarItemVendaPK(produto2,venda2);
		ItemVendaPK itemVendaRemovPK3 = UtilsTest.criarItemVendaPK(produto3,venda2);
		
		//CRIAÇÃO DE ITENS DE VENDA
		ItemVenda itemVendaRemov1 = UtilsTest.criarItemVenda(itemVendaRemovPK);
		ItemVenda itemVendaRemov2 = UtilsTest.criarItemVenda(itemVendaRemovPK2);
		ItemVenda itemVendaRemov3 = UtilsTest.criarItemVenda(itemVendaRemovPK3);
		
		itemVendaRepository.save(itemVendaRemov1);
		itemVendaRepository.save(itemVendaRemov2);
		itemVendaRepository.save(itemVendaRemov3);
		
		itensVenda = Arrays.asList(
				itemVenda1,itemVenda2,itemVenda3
				);
		vendaRemov2.setItensVenda(itensVenda);
		
		vendaRepository.save(vendaRemov2);
	}

	@Test
	public void testUpdate() {
		Venda vendaUpdate = UtilsTest.criarVenda(cliente, funcionario);
		vendaUpdate.setItensVenda(itensVenda); 
		assertTrue(vendaService.update(venda2,vendaUpdate));
		assertEquals(vendaUpdate, vendaService.findById(vendaUpdate.getId()).get());
	}

	@Test
	public void testFindById() {
		assertTrue(vendaService.equals(vendaService.findById(venda1.getId()).get()));
	}
;
	@Test
	public void testFindAll() {
		assertTrue(vendaService.findById(venda1.getId()).isPresent());
		assertTrue(vendaService.findById(venda2.getId()).isPresent());
	}

}
