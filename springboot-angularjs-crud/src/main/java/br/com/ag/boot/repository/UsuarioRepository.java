package br.com.ag.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ag.boot.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
