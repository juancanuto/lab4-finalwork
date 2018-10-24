package br.gov.edu.fatec.lab4.loja.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native") 
	private int id;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private Integer cep;
}
