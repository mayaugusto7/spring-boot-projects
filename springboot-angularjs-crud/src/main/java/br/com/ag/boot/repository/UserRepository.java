package br.com.ag.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ag.boot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
}
