package br.com.ag.boot.service.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ag.boot.model.Todo;
import br.com.ag.boot.repository.TodoRepository;
import br.com.ag.boot.service.todo.ITodoService;

@Service
public class TodoServiceImpl implements ITodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public void createTodo(Todo todo) {
		todoRepository.save(todo);
	}

	@Override
	public List<Todo> listarTodos() {
		return todoRepository.findAll();
	}

	@Override
	public void removerTodo(Long id) {
		todoRepository.deleteById(id);
	}

	@Override
	public Optional<Todo> findById(Long id) {
		return todoRepository.findById(id);
	}

	@Override
	public Todo updateTodo(Todo currentTodo) {
		return todoRepository.save(currentTodo);
	}

	@Override
	public boolean isTodoExist(Todo todo) {
		return todoRepository.findByNome(todo.getNome()) != null;
	}

	@Override
	public void deleteAllTodos() {
		todoRepository.deleteAll();
	}
	
}
