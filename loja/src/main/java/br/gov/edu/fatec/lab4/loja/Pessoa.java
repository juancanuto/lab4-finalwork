package br.gov.edu.fatec.lab4.loja;

import java.time.ZonedDateTime;
import java.time.temporal.Temporal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Data
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native")
	private Integer id;
	
	private String nome;
	private Integer cpf;
	private Integer rg;
	@Column(name="data_nascimento")
	private ZonedDateTime dataNascimento;
	private String sexo;
}
