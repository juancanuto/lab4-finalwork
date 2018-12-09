package br.gov.edu.fatec.lab4.loja.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.edu.fatec.lab4.loja.Pessoa;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
}
