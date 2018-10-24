package br.gov.edu.fatec.lab4.loja.fornecedor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import br.gov.edu.fatec.lab4.loja.endereco.Endereco;
import br.gov.edu.fatec.lab4.loja.produto.Produto;
import br.gov.edu.fatec.lab4.loja.telefone.Telefone;
import lombok.Data;
@Entity
@Data
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native")
	private Integer id;
	private String nome;
	private Integer cnpj;
	private Endereco endereco;
	@ManyToMany(mappedBy="fornecedores")
	private List<Produto> produtos;
	@ManyToMany
	@JoinTable(name="telefone_fornecedor",
    joinColumns={@JoinColumn(name="telefone_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="fornecedor_id", referencedColumnName="id")})
	private List<Telefone> telefones;
}
