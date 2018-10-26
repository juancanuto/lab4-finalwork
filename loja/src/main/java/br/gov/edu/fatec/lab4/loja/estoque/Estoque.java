package br.gov.edu.fatec.lab4.loja.estoque;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.gov.edu.fatec.lab4.loja.produto.Produto;
import lombok.Data;

@Entity
@Data
public class Estoque {
	@Id
	private int id;
	@OneToOne
	private Produto produto;
	private Integer quantidade;
	private Integer qtdMinima;
}