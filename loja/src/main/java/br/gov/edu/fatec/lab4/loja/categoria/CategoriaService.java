package br.gov.edu.fatec.lab4.loja.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements CategoriaServiceImpl{
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@Override
	public Optional<Categoria> findById(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.isPresent()?categoria:null;
	}

	@Override
	public boolean save(Categoria categoria) {
		categoriaRepository.save(categoria);
		return categoriaRepository.existsById(categoria.getId())?true:false;
	}

	@Override
	public Categoria remove(Categoria categoria) {
		categoriaRepository.delete(categoria);
		return categoria;
	}

	@Override
	public boolean update(Categoria categoria, Categoria categoriaAtualizada) {
		Optional<Categoria> c = findById(categoria.getId());
		if(c.isPresent()) {
			categoriaAtualizada.setId(c.get().getId());
			return save(categoriaAtualizada);
		}
		return false;	
	}

	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
}
