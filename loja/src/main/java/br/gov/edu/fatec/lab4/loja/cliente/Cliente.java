package br.gov.edu.fatec.lab4.loja.cliente;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import br.gov.edu.fatec.lab4.loja.Pessoa;
import br.gov.edu.fatec.lab4.loja.endereco.Endereco;
import br.gov.edu.fatec.lab4.loja.telefone.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Cliente extends Pessoa{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3450409573233859411L;
	@ManyToMany
	@JoinTable(name="telefone_cliente",
    joinColumns={@JoinColumn(name="telefone_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="cliente_id", referencedColumnName="id")})
	List<Telefone> telefones;
	
	@Builder
	public Cliente(Integer id,String nome,Integer cpf, Integer rg,Endereco endereco,List<Telefone>telefones) {
		super(id, nome, cpf, rg, null, null, endereco);
		this.telefones = telefones;
	}
}