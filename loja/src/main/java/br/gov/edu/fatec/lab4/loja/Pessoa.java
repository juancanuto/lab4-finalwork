package br.gov.edu.fatec.lab4.loja;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.gov.edu.fatec.lab4.loja.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6433274588263991424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private Integer cpf;
	
	@NotNull
	private Integer rg;
	
	@Column(name="data_nascimento")
	private ZonedDateTime dataNascimento;
	
	private String sexo;
	
	@OneToOne
	private Endereco endereco;
}
