package br.gov.edu.fatec.lab4.loja.venda;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.gov.edu.fatec.lab4.loja.cliente.Cliente;
import br.gov.edu.fatec.lab4.loja.funcionario.Funcionario;
import br.gov.edu.fatec.lab4.loja.funcionario.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy="itemVendaPK.venda", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ItemVenda> itensVenda;
	
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
