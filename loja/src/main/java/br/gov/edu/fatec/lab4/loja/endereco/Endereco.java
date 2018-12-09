package br.gov.edu.fatec.lab4.loja.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private Estado estado;
	private Integer cep;
	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", cep=" + cep + "]";
	}
	
	
}
