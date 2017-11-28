package br.com.mones.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.mones.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findById(Long id);
}
