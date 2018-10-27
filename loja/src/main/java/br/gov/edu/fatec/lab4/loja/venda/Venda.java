package br.gov.edu.fatec.lab4.loja.venda;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import br.gov.edu.fatec.lab4.loja.cliente.Cliente;
import br.gov.edu.fatec.lab4.loja.funcionario.Funcionario;
import br.gov.edu.fatec.lab4.loja.produto.Produto;
import lombok.Data;
@Entity
@Data
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@OneToMany
	private List<Produto> produtos;
	
	@OneToOne(orphanRemoval=true)
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	
	@Column(name="forma_pgto")
	private FormaPagamento formaPagamento;
	
	@Column(name="valor_pago")
	private Double valorPago;
	
	@Column(name="num_parcelas")
	private int parcelas;
	
}
