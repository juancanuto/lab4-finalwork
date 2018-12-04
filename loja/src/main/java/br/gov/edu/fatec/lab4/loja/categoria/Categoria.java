package br.gov.edu.fatec.lab4.loja.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
@Entity
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
