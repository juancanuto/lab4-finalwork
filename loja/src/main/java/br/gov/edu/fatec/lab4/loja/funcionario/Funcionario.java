package br.gov.edu.fatec.lab4.loja.funcionario;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.gov.edu.fatec.lab4.loja.Pessoa;
import br.gov.edu.fatec.lab4.loja.endereco.Endereco;
import br.gov.edu.fatec.lab4.loja.usuario.Usuario;
import br.gov.edu.fatec.lab4.loja.venda.Venda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Funcionario extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3058245074261624692L;

	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToMany()
	private List<Venda> vendas;

	@Builder
	public Funcionario(String nome,Integer cpf, Integer rg,Endereco endereco,Usuario usuario,List<Venda>vendas) {
		super(null, nome, cpf, rg, null, null, endereco);
		this.usuario = usuario;
		this.vendas = vendas;
	}
}
