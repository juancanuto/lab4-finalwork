package br.gov.edu.fatec.lab4.loja;

import java.time.temporal.Temporal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Data
@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native")
	private Integer id;
	
	private String nome;
	private Integer cpf;
	private Integer rg;
	private Temporal dataNascimento;
	private String sexo;
}
