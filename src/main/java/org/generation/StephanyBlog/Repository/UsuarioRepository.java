package org.generation.StephanyBlog.Repository;

import java.util.Optional;

import org.generation.StephanyBlog.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional <Usuario>findByUsuario(String usuario);

	
}
