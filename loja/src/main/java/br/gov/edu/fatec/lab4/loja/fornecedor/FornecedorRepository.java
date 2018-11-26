package br.gov.edu.fatec.lab4.loja.fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

}
