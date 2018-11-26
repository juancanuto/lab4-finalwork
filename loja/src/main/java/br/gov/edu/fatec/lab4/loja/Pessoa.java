package br.gov.edu.fatec.lab4.loja;

import java.time.ZonedDateTime;
import java.time.temporal.Temporal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import br.gov.edu.fatec.lab4.loja.endereco.Endereco;
import br.gov.edu.fatec.lab4.loja.telefone.Telefone;
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
	@OneToOne
	private Endereco endereco;
	
	
}
