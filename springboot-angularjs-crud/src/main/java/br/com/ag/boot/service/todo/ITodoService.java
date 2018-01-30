package br.com.ag.boot.service.todo;

import java.util.List;
import java.util.Optional;

import br.com.ag.boot.model.Todo;

public interface ITodoService {

	void createTodo(Todo todo);

	List<Todo> listarTodos();

	void removerTodo(Long id);

	Optional<Todo> findById(Long id);

	Todo updateTodo(Todo currentTodo);

	boolean isTodoExist(Todo todo);

	void deleteAllTodos();

}
