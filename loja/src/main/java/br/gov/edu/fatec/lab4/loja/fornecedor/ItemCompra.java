package br.gov.edu.fatec.lab4.loja.fornecedor;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.gov.edu.fatec.lab4.loja.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fornecedor_produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemCompra implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 68779708451841729L;
	
	@EmbeddedId
	ItemCompraPK itemCompraPK;
	
	Calendar data_entrada;
	
	Double valor_custo;
}
