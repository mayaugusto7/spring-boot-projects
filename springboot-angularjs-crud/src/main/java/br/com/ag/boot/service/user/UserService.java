package br.com.ag.boot.service.user;

import java.util.List;
import java.util.Optional;

import br.com.ag.boot.model.User;

public interface UserService {

	Optional<User> findById(Long id);

	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	void deleteAllUsers();
	
	List<User> findAllUsers();
	
	boolean isUserExist(User user);

}
