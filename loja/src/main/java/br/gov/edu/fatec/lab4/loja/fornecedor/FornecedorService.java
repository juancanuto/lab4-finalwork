package br.gov.edu.fatec.lab4.loja.fornecedor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FornecedorService implements FornecedorServiceImpl {

	@Autowired
	public FornecedorRepository fornecedorRepository;
	
	@Override
	public Optional<Fornecedor> findById(Integer id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return fornecedor.isPresent()?fornecedor:null;
	}

	@Override
	public boolean save(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
		return fornecedorRepository.existsById(fornecedor.getId())?true:false;
	}

	@Override
	public Fornecedor remove(Fornecedor fornecedor) {
		fornecedorRepository.delete(fornecedor);
		return fornecedor;
	}

	@Override
	public boolean update(Fornecedor fornecedor, Fornecedor fornedorAtualizado) {
		Optional<Fornecedor> c = findById(fornecedor.getId());
		if(c.isPresent()) {
			fornedorAtualizado.setId(c.get().getId());
			return save(fornedorAtualizado);
		}
		return false;	
	}

	@Override
	public List<Fornecedor> findAll() {
		return fornecedorRepository.findAll();
	}
}
