package br.com.ag.boot.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ag.boot.model.User;
import br.com.ag.boot.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		this.saveUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public void deleteAllUsers() {
		 userRepository.deleteAll();
	}

	@Override
	public List<User> findAllUsers() {
		 return userRepository.findAll();
	}

	@Override
	public boolean isUserExist(User user) {
		 return this.findByName(user.getName()) != null;
	}

}
