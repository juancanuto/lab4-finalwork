package br.gov.edu.fatec.lab4.loja.venda;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.gov.edu.fatec.lab4.loja.produto.Produto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemVenda {
	@ManyToOne
	@JoinColumn(name = "produto_id")
	Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="venda_id")
	Venda venda;
	
	Date data_venda;
	
	Integer quantidade;
}
