package br.gov.edu.fatec.lab4.loja.relatorios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.edu.fatec.lab4.loja.fornecedor.Fornecedor;
import br.gov.edu.fatec.lab4.loja.fornecedor.ItemCompra;
import br.gov.edu.fatec.lab4.loja.fornecedor.ItemCompraRepository;
import br.gov.edu.fatec.lab4.loja.produto.Produto;
import br.gov.edu.fatec.lab4.loja.venda.ItemVenda;
import br.gov.edu.fatec.lab4.loja.venda.ItemVendaRepository;
import br.gov.edu.fatec.lab4.loja.venda.Venda;

public class Relatorio {
	@Autowired
	public ItemCompraRepository itemCompraRepository;
	private ItemVendaRepository itemVendaRepository;
	
//	public void emitirRelatorioMovimentoDiarioDeEntrada(Date dataConsulta) {
//		List<ItemCompra> itensEntrada = itemCompraRepository.findItemCompradataEntrada(dataConsulta);
//		Produto produto;
//		Fornecedor fornecedor=null;
//		for (ItemCompra itemCompra : itensEntrada) {
//			produto = itemCompra.getItemCompraPK().getProduto();
//			fornecedor = itemCompra.getItemCompraPK().getFornecedor();
//			System.out.println("Data Entrada: "+itemCompra.getDataEntrada()+"\n");
//			System.out.println("Valor do Item: "+itemCompra.getValorCusto()+"\n");
//			System.out.println(produto.toString());
//			System.out.println(fornecedor.toString());
//			
//		}
//	}
//	
//	public void emitirRelatorioMovimentoDiarioDeSaida(Date dataConsulta) {
//		List<ItemVenda> itensVenda = itemVendaRepository.findByItemVendaDataEntrada(dataConsulta);
//		Produto produto;
//		Venda venda=null;
//		for (ItemVenda itemVenda : itensVenda) {
//			produto = itemVenda.getItemVendaPK().getProduto();
//			venda = itemVenda.getItemVendaPK().getVenda();
//			System.out.println("Data Entrada: "+itemVenda.getDataVenda()+"\n");
//			System.out.println("Valor do Item: "+itemVenda.getQuantidade()+"\n");
//			System.out.println(produto.toString());
//			System.out.println(venda.toString());
//		}
//	}
}