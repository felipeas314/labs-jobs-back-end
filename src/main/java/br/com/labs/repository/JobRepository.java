package br.com.labs.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.labs.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
