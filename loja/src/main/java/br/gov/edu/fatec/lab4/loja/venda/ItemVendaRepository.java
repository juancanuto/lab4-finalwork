package br.gov.edu.fatec.lab4.loja.venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {
	
//	@Query(name="from ItemVenda where dataVenda := dataVenda")
//	List<ItemVenda> findByItemVendaDataEntrada(Date dataVenda);
}
