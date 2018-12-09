package br.gov.edu.fatec.lab4.loja.funcionario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.edu.fatec.lab4.loja.Pessoa;
@Service
public class FuncionarioService implements IFuncionarioServiceImpl {

	@Autowired
	public FuncionarioRepository funcionarioRepository;
	
	@Override
	public boolean save(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		Pessoa funcionarioRetorno = findById(funcionario.getId()).get();
		return funcionarioRetorno.equals(funcionario);
	}

	@Override
	public Funcionario remove(Funcionario funcionario) {
		funcionarioRepository.delete(funcionario);
		return funcionario;
	}

	@Override
	public boolean update(Funcionario funcionario, Funcionario funcionarioUpdate) {
		Optional<Funcionario> c = findById(funcionario.getId());
		if(c.isPresent()) {
			funcionarioUpdate.setId(c.get().getId());
			return save(funcionarioUpdate);
		}
		return false;
	}

	@Override
	public Optional<Funcionario> findById(Integer id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.isPresent()?funcionario:null;
	}

	@Override
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}	
}
