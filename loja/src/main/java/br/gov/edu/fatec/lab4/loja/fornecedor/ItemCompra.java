package br.gov.edu.fatec.lab4.loja.fornecedor;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.edu.fatec.lab4.loja.produto.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fornecedor_produto")
@Data
@NoArgsConstructor
public class ItemCompra implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 68779708451841729L;

	@Id
	@ManyToOne
	@JoinColumn(name = "produto_id")
	Produto produto;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fornecedor_id")
	Fornecedor fornecedor;
	
	Calendar data_entrada;
	
	Double valor_custo;
}
