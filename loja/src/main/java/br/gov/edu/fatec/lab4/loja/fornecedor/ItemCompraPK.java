package br.gov.edu.fatec.lab4.loja.fornecedor;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.gov.edu.fatec.lab4.loja.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemCompraPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6131007568368528226L;


	@ManyToOne
	@JoinColumn(name = "produto_id")
	Produto produto;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fornecedor_id")
	Fornecedor fornecedor;
}
