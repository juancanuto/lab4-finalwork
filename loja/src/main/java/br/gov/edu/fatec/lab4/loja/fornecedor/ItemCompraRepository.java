package br.gov.edu.fatec.lab4.loja.fornecedor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, Integer> {
	Optional<ItemCompra> findByItemCompraPK(ItemCompraPK itemCompraPK);
}
