package br.com.labs.model;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Job {

	@Id
	private UUID id;

	private String title;
	
	private String description;
	
	private BigDecimal salary;
}
