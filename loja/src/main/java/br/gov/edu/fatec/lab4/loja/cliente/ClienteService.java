package br.gov.edu.fatec.lab4.loja.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService implements ClienteServiceImpl {

	@Autowired
	public ClienteRepository clienteRepository;
	
	@Override
	public boolean save(Cliente cliente) {
		clienteRepository.save(cliente);
		return clienteRepository.existsById(cliente.getId());
	}

	@Override
	public Cliente remove(Cliente cliente) {
		clienteRepository.delete(cliente);
		return cliente;
	}

	@Override
	public boolean update(Cliente cliente, Cliente clienteUpdate) {
		Optional<Cliente> c = findById(cliente.getId());
		if(c.isPresent()) {
			clienteUpdate.setId(c.get().getId());
			return save(clienteUpdate);
		}
		return false;
	}

	@Override
	public Optional<Cliente> findById(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.isPresent()?cliente:null;
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

}
