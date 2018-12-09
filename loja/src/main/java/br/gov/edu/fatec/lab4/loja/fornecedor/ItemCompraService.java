package br.gov.edu.fatec.lab4.loja.fornecedor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ItemCompraService implements ItemCompraServiceImpl {

	@Autowired
	public ItemCompraRepository ItemCompraRepository;
	
	@Override
	public Optional<ItemCompra> findById(Integer id) {
		Optional<ItemCompra> ItemCompra = ItemCompraRepository.findById(id);
		return ItemCompra.isPresent()?ItemCompra:null;
	}

	@Override
	public boolean save(ItemCompra ItemCompra) {
		ItemCompraPK itemCompraPK = ItemCompra.getItemCompraPK();
		ItemCompra = ItemCompraRepository.save(ItemCompra);
		return ItemCompra.getItemCompraPK().equals(itemCompraPK);
	}

	@Override
	public ItemCompra remove(ItemCompra ItemCompra) {
		ItemCompraRepository.delete(ItemCompra);
		return ItemCompra;
	}

	@Override
	public boolean update(ItemCompra ItemCompra, ItemCompra itemCompraUpdate) {
		Optional<ItemCompra> c = ItemCompraRepository.findByItemCompraPK(ItemCompra.getItemCompraPK());
		if(c.isPresent()) {
			ItemCompra item = c.get();
			item = itemCompraUpdate;
			return save(item);
		}
		return false;	
	}

	@Override
	public List<ItemCompra> findAll() {
		return ItemCompraRepository.findAll();
	}

}
