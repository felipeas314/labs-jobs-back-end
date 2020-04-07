package br.com.labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.labs.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
