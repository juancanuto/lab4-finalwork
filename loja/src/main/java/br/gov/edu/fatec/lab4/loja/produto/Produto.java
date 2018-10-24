package br.gov.edu.fatec.lab4.loja.produto;

import java.time.temporal.Temporal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import br.gov.edu.fatec.lab4.loja.categoria.Categoria;
import br.gov.edu.fatec.lab4.loja.fornecedor.Fornecedor;
import br.gov.edu.fatec.lab4.loja.telefone.Telefone;
import lombok.Data;

@Entity
@Data
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native")
	private Integer id;
	@OneToOne
	private Categoria categoria;
	@ManyToMany
	@JoinTable(name="fornecedor_produto",
    joinColumns={@JoinColumn(name="fornecedor_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="produto_id", referencedColumnName="id")})
	private List<Fornecedor> fornecedores;
	private String nome;
	private String marca;
	private String modelo;
	private String cor;
	private String tamanho;
	private Double valor;
	private String observacao;
	private Temporal dataFabricacao;
}
