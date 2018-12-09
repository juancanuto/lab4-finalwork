package br.gov.edu.fatec.lab4.loja.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GenericGenerator(name="native", strategy = "native")
	private Integer id;
	private String nome;
}
