package br.gov.edu.fatec.lab4.loja.venda;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.edu.fatec.lab4.loja.produto.Produto;
@Service
public class VendaService implements VendaServiceImpl {
	@Autowired
	public VendaRepository vendaRepository;
	
	@Override
	public boolean save(Venda venda) {
		vendaRepository.save(venda);
		return vendaRepository.existsById(venda.getId());
	}

	@Override
	public Venda remove(Venda venda) {
		vendaRepository.delete(venda);
		return venda;
	}

	@Override
	public boolean update(Venda venda, Venda vendaUpdate) {
		Optional<Venda> c = findById(venda.getId());
		if(c.isPresent()) {
			vendaUpdate.setId(c.get().getId());
			return save(vendaUpdate);
		}
		return false;
	}

	@Override
	public Optional<Venda> findById(Integer id) {
		Optional<Venda> venda = vendaRepository.findById(id);
		return venda.isPresent()?venda:null;
	}

	@Override
	public List<Venda> findAll() {
		return vendaRepository.findAll();
	}

}
