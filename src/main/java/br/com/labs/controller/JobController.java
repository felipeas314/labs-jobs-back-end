package br.com.labs.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.labs.model.Job;
import br.com.labs.repository.JobRepository;

@RestController
@RequestMapping("/jobs")
public class JobController {

	private JobRepository jobRepository;

	public JobController(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@PostMapping
	public ResponseEntity<Job> create(@Valid @RequestBody Job job) {

		jobRepository.save(job);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(job.getId())
				.toUri();

		return ResponseEntity.created(location).body(job);
	}
}
