package br.com.labs.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.labs.model.User;

public interface UserRepository extends ReactiveMongoRepository<User, UUID> {

}
