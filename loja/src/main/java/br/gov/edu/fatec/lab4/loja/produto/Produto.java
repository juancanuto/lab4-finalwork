package br.gov.edu.fatec.lab4.loja.produto;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import br.gov.edu.fatec.lab4.loja.categoria.Categoria;
import br.gov.edu.fatec.lab4.loja.estoque.Estoque;
import br.gov.edu.fatec.lab4.loja.fornecedor.ItemCompra;
import br.gov.edu.fatec.lab4.loja.venda.ItemVenda;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy="produto", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<ItemCompra> itensCompra;
	
	@OneToMany(mappedBy="produto", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<ItemVenda> itensVenda;
	
	@OneToOne(mappedBy="produto")
	private Estoque estoque;
	
	private String nome;
	private String marca;
	private String modelo;
	private String cor;
	private String tamanho;
	private Double valor;
	private String observacao;
	@Column(name="data_fabricacao")
	private ZonedDateTime dataFabricacao;
}
