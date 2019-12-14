package br.com.labs.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.labs.model.Job;

public interface JobRepository extends ReactiveMongoRepository<Job, UUID> {

}
