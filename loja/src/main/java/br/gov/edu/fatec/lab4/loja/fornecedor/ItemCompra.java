package br.gov.edu.fatec.lab4.loja.fornecedor;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.edu.fatec.lab4.loja.produto.Produto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="fornecedor_produto")
@Getter
@Setter
public class ItemCompra {

	@ManyToOne
	@JoinColumn(name = "id_produto")
	Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_fornecedor")
	Fornecedor fornecedor;
	
	@Column(name="data_entrada")
	Calendar data_entrada;
	
	@Column(name="valor_custo")
	Double valor_custo;
}
