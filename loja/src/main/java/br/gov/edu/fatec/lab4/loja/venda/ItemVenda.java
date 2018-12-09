package br.gov.edu.fatec.lab4.loja.venda;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.edu.fatec.lab4.loja.fornecedor.ItemCompra;
import br.gov.edu.fatec.lab4.loja.fornecedor.ItemCompraPK;
import br.gov.edu.fatec.lab4.loja.fornecedor.ItemCompra.ItemCompraBuilder;
import br.gov.edu.fatec.lab4.loja.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="item_venda")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemVenda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7081738732278992122L;
	
	@EmbeddedId
	ItemVendaPK itemVendaPK;
	
	@Column(name="data_venda")
	Date dataVenda;
	
	Integer quantidade;
}
