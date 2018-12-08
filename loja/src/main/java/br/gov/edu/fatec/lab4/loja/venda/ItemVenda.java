package br.gov.edu.fatec.lab4.loja.venda;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="item_venda")
@Data
@NoArgsConstructor
public class ItemVenda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7081738732278992122L;
	@Id
	@ManyToOne
	@JoinColumn(name = "produto_id")
	Produto produto;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="venda_id")
	Venda venda;
	
	Date data_venda;
	
	Integer quantidade;
}
