package br.gov.edu.fatec.lab4.loja.venda;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.edu.fatec.lab4.loja.cliente.Cliente;
import br.gov.edu.fatec.lab4.loja.estoque.Estoque;
import br.gov.edu.fatec.lab4.loja.estoque.EstoqueService;
import br.gov.edu.fatec.lab4.loja.funcionario.Funcionario;
import br.gov.edu.fatec.lab4.loja.produto.Produto;
@Service
public class VendaService implements VendaServiceImpl {
	@Autowired
	public VendaRepository vendaRepository;
	
	@Autowired
	public EstoqueService estoqueService;
	
	@Autowired
	public VendaService vendaService;
	
	@Autowired
	public ItemVendaRepository itemVendaRepository;
	
	@Autowired
	public ItemVenda itemVenda;
	
	@Autowired
	private EstoqueService estoqueservice;

	
	@Override
	public boolean save(Venda venda) {
		vendaRepository.save(venda);
		return vendaRepository.existsById(venda.getId());
	}

	@Override
	public Venda remove(Venda venda) {
		vendaRepository.delete(venda);
		return venda;
	}

	@Override
	public boolean update(Venda venda, Venda vendaUpdate) {
		Optional<Venda> c = findById(venda.getId());
		if(c.isPresent()) {
			vendaUpdate.setId(c.get().getId());
			return save(vendaUpdate);
		}
		return false;
	}

	@Override
	public Optional<Venda> findById(Integer id) {
		Optional<Venda> venda = vendaRepository.findById(id);
		return venda.isPresent()?venda:null;
	}

	@Override
	public List<Venda> findAll() {
		return vendaRepository.findAll();
	}
	
	public void realizarVenda(Produto produto, Cliente cliente,
			FormaPagamento formaPagamento, Funcionario funcionario, Double valorPago, int parcelas) {
		Estoque estoqueRetorno = estoqueService.findByProduto(produto);
		if(estoqueRetorno!=null) {
			Venda venda = Venda.builder().
					cliente(cliente).
					funcionario(funcionario).
					valorPago(valorPago).
					build();
			if(formaPagamento.equals(FormaPagamento.CARTAO_CREDITO)) {
				venda.setParcelas(parcelas);
			}
			vendaService.save(venda);
			ItemVendaPK itemVendaPK = ItemVendaPK.builder().
					produto(produto)
					.venda(venda).build();			
			ItemVenda itemVenda = ItemVenda.builder().
					itemVendaPK(itemVendaPK). 
					data_venda(new Date()).
					quantidade(1) 
					.build();
			venda.setItensVenda(Arrays.asList(itemVenda));
			vendaService.save(venda);
			estoqueRetorno.setQuantidade(estoqueRetorno.getQuantidade()-1);
			estoqueservice.save(estoqueRetorno);
		}
	}

}
