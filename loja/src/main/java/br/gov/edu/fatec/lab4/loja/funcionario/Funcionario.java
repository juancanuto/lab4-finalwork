package br.gov.edu.fatec.lab4.loja.funcionario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import br.gov.edu.fatec.lab4.loja.Pessoa;
import br.gov.edu.fatec.lab4.loja.usuario.Usuario;
import lombok.Data;

@Entity
@Data
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
}
