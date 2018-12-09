package br.gov.edu.fatec.lab4.loja.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.edu.fatec.lab4.loja.Pessoa;

public class ClienteService implements ClienteServiceImpl {

	@Autowired
	public ClienteRepository clienteRepository;
	
	@Override
	public boolean save(Pessoa cliente) {
		clienteRepository.save(cliente);
		return clienteRepository.existsById(cliente.getId());
	}

	@Override
	public Pessoa remove(Pessoa cliente) {
		clienteRepository.delete(cliente);
		return cliente;
	}

	@Override
	public boolean update(Pessoa cliente, Pessoa clienteUpdate) {
		Optional<Pessoa> c = findById(cliente.getId());
		if(c.isPresent()) {
			clienteUpdate.setId(c.get().getId());
			return save(clienteUpdate);
		}
		return false;
	};

	@Override
	public Optional<Pessoa> findById(Integer id) {
		Optional<Pessoa> cliente = clienteRepository.findById(id);
		return cliente.isPresent()?cliente:null;
	}

	@Override
	public List<Pessoa> findAll() {
		return clienteRepository.findAll();
	}

}
