package br.gov.edu.fatec.lab4.loja.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements CategoriaServiceImpl{
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria findById(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria!=null) {
			return categoria.get();
		};
		return null;
	}
	
	@Override
	public boolean salvar(Categoria categoria) {
		Categoria categoriaSalva;
		categoriaRepository.save(categoria);
		categoriaSalva = findById(categoria.getId());
		if(categoriaSalva!=null) {
			return true;
		}
		return false;
	}
}
