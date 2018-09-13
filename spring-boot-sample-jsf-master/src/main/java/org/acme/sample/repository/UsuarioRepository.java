package org.acme.sample.repository;

import org.acme.sample.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByUsuario(String usuario);
}
