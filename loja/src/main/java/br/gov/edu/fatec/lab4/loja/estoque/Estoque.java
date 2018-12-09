package br.gov.edu.fatec.lab4.loja.estoque;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.gov.edu.fatec.lab4.loja.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estoque {
	@Id
	private int id;
	@OneToOne
	@JoinColumn(name = "produto_id", unique=true, referencedColumnName="id")
	private Produto produto;
	private Integer quantidade;
	private Integer qtdMinima;
}
