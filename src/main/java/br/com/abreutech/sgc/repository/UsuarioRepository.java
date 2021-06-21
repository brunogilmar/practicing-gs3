package br.com.abreutech.sgc.repository;

import br.com.abreutech.sgc.modelo.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaBaseRepository<Usuario, Long> {

    Optional<Usuario> findByUsuario(String usuario);

}
