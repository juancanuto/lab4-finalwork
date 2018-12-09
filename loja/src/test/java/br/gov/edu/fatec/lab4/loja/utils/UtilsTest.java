package br.gov.edu.fatec.lab4.loja.utils;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.gov.edu.fatec.lab4.loja.Pessoa;
import br.gov.edu.fatec.lab4.loja.categoria.Categoria;
import br.gov.edu.fatec.lab4.loja.cliente.Cliente;
import br.gov.edu.fatec.lab4.loja.endereco.Endereco;
import br.gov.edu.fatec.lab4.loja.endereco.Estado;
import br.gov.edu.fatec.lab4.loja.enuns.TipoCor;
import br.gov.edu.fatec.lab4.loja.fornecedor.Fornecedor;
import br.gov.edu.fatec.lab4.loja.fornecedor.ItemCompra;
import br.gov.edu.fatec.lab4.loja.funcionario.Funcionario;
import br.gov.edu.fatec.lab4.loja.produto.Produto;
import br.gov.edu.fatec.lab4.loja.telefone.Telefone;
import br.gov.edu.fatec.lab4.loja.telefone.TipoTelefone;
import br.gov.edu.fatec.lab4.loja.usuario.Usuario;
import br.gov.edu.fatec.lab4.loja.venda.FormaPagamento;
import br.gov.edu.fatec.lab4.loja.venda.ItemVenda;
import br.gov.edu.fatec.lab4.loja.venda.ItemVendaPK;
import br.gov.edu.fatec.lab4.loja.venda.Venda;

public class UtilsTest {
	

	public static Endereco criarEndereco() {
		return Endereco.builder().rua("Otavio Moraes Lopes").
						bairro("Jd Americano").
						cidade("São José dos Campos").
						estado(Estado.SP).
						cep(12225484).
						build();
	}
	
	public static Fornecedor criarFornecedor() {
		return Fornecedor.builder().
				cnpj(1234567897).build();
	}
	
	public static Categoria criarCategoria() {
		return Categoria.builder().nome("Veiculos").build();
	}
	
	public static Produto criarProduto() {
		return Produto.builder().cor(TipoCor.VERDE.getCor()).
				dataFabricacao(new Date()).
				nome("Carro").
				marca("Chevrolet").
				modelo("Agile").
				cor("Verde"). 
				dataFabricacao(new Date()). 
				valor(20000.00).
				build();
	}
	
	public static ItemCompra criarItemCompra() {
		return ItemCompra.builder().
				dataEntrada(Calendar.getInstance()).
				valorCusto(15000.20).
				build();
	}

	public static Venda criarVenda(Cliente cliente, Funcionario funcionario) {
		return Venda.builder().
				cliente(cliente).
				formaPagamento(FormaPagamento.CARTAO_CREDITO).
				funcionario(funcionario).
				parcelas(3).
				valorPago(2000.00).
				build();
	}

	public static Cliente criarCliente(Integer id,String nome, Integer cpf, Integer rg, Endereco endereco) {	
		return Cliente.builder().
				telefones(Arrays.asList(
						criarTelefone(39524548,12),
						criarTelefone(39527888,12),
						criarTelefone(39522223,12)
						)).
				id(id).
				nome(nome).
				cpf(cpf).
				rg(rg).
				endereco(endereco).
				build();
	}
	
	public static Telefone criarTelefone(Integer numero, Integer ddd) {
		return Telefone.builder().
					ddd(ddd).
					numero(numero).
					tipo(TipoTelefone.COMERCIAL).
				build();
	}
	
	public static Pessoa criarPessoa(String nome, Integer cpf, Integer rg, ZonedDateTime dataNascimento, String sexo, Endereco endereco) {
		return new Pessoa(null, nome, cpf, rg, dataNascimento, sexo, endereco);
	}
	
	public static Funcionario criarFuncionario(Usuario usuario,String nome, Integer cpf, Integer rg, Endereco endereco) {
		return Funcionario.builder().
					usuario(usuario).
					nome(nome).
					cpf(cpf).
					rg(rg).
					endereco(endereco).	
				build();
	}

	public static Usuario criarUsuario(String nome, String senha) {
		return Usuario.builder().
					nome(nome).
					senha(senha).
				build();
	}

	public static ItemVenda criarItemVenda(ItemVendaPK itemVendaPK) {
		return ItemVenda.builder().
					dataVenda(new Date()).
					itemVendaPK(itemVendaPK).
					quantidade(3).				
				build();
	}

	public static ItemVendaPK criarItemVendaPK(Produto produto, Venda venda) {
		return ItemVendaPK.builder().
					produto(produto).
					venda(venda).	
				build();
	}

	
}
