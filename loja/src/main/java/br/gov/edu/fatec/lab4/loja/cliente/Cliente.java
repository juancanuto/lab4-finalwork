package br.gov.edu.fatec.lab4.loja.cliente;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.gov.edu.fatec.lab4.loja.Pessoa;
import br.gov.edu.fatec.lab4.loja.endereco.Endereco;
import br.gov.edu.fatec.lab4.loja.telefone.Telefone;
import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Cliente extends Pessoa{
	@OneToOne
	private Endereco endereco;
	
	@ManyToMany
	@JoinTable(name="telefone_cliente",
    joinColumns={@JoinColumn(name="telefone_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="cliente_id", referencedColumnName="id")})
	List<Telefone> telefones;
}
