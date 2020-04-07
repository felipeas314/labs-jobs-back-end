package br.com.labs.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.labs.model.Company;
import br.com.labs.repository.CompanyRepository;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyRepository companyRepository;

	public CompanyController(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public ResponseEntity<Page<Company>> index(@PageableDefault() Pageable pageable) {
		return ResponseEntity.ok(companyRepository.findAll(pageable));
	}

	public ResponseEntity<Company> create(@Valid @RequestBody Company company) {
		companyRepository.save(company);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(company.getId())
				.toUri();

		return ResponseEntity.created(location).body(company);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> show(@PathVariable("id") Integer id) {
		return companyRepository.findById(id)
				.map(category -> ResponseEntity.ok().body(category))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Company> update(@Valid @RequestBody Company company, @PathVariable("id") Integer id) {
		return companyRepository.findById(id)
				.map(c -> {
					c.setName(company.getName());
					return ResponseEntity.ok(c);
				}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> destroy(@PathVariable("id") Integer id) {
		return companyRepository.findById(id)
				.map(company -> {
					companyRepository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
}
