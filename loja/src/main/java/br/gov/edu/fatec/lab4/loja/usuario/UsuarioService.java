package br.gov.edu.fatec.lab4.loja.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioServiceImpl {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Override
	public boolean save(Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuarioRepository.findById(usuario.getId()).equals(usuario);
	}

	@Override
	public Usuario remove(Usuario usuario) {
		usuarioRepository.delete(usuario);
		return usuario;
	}

	@Override
	public boolean update(Usuario usuario, Usuario UsuarioUpdate) {
		Optional<Usuario> c = findById(usuario.getId());
		if(c.isPresent()) {
			UsuarioUpdate.setId(c.get().getId());
			return save(UsuarioUpdate);
		}
		return false;
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		Optional<Usuario> Usuario = usuarioRepository.findById(id);
		return Usuario.isPresent()?Usuario:null;
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
}
