package br.gov.edu.fatec.lab4.loja.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@AllArgsConstructor
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GenericGenerator(name="native", strategy = "native")
	private Integer id;
	private String nome;
	
	public Categoria(String nome) {
		setNome(nome);
	}
}
