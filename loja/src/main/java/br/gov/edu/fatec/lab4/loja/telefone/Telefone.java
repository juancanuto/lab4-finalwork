package br.gov.edu.fatec.lab4.loja.telefone;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import br.gov.edu.fatec.lab4.loja.cliente.Cliente;
import br.gov.edu.fatec.lab4.loja.fornecedor.Fornecedor;
import lombok.Data;
@Entity
@Data
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native")
	private Integer id;
	private Integer numero;
	private Integer ddd;
	private TipoTelefone tipo;
	@ManyToMany(mappedBy = "telefones")
	private List<Cliente>clientes;
	@ManyToMany(mappedBy = "telefones")
	private List<Fornecedor> fornecedores;
}
