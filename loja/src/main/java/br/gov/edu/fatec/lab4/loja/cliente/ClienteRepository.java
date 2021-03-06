package br.gov.edu.fatec.lab4.loja.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.edu.fatec.lab4.loja.Pessoa;
@Repository
public interface ClienteRepository extends JpaRepository<Pessoa, Integer> {

}
