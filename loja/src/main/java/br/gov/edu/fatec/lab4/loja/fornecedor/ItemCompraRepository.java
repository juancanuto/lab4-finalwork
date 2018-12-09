package br.gov.edu.fatec.lab4.loja.fornecedor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, Integer> {
	Optional<ItemCompra> findByItemCompraPK(ItemCompraPK itemCompraPK);
	
//	@Query(name="from ItemCompra where data_entrada := dataEntrada")
//	List<ItemCompra> findItemCompradataEntrada(Date dataEntrada);
}
