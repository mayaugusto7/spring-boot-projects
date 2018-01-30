package br.com.ag.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ag.boot.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}
