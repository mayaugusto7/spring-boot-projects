package br.com.ag.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ag.boot.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	Todo findByNome(String nome);

}
