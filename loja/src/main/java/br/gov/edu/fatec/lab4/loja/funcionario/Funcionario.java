package br.gov.edu.fatec.lab4.loja.funcionario;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.gov.edu.fatec.lab4.loja.Pessoa;
import br.gov.edu.fatec.lab4.loja.usuario.Usuario;
import br.gov.edu.fatec.lab4.loja.venda.Venda;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Data
@EqualsAndHashCode(callSuper=false)
public class Funcionario extends Pessoa{
	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToMany()
	private List<Venda> vendas;

}
