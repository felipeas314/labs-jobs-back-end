package br.com.labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.labs.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
