package br.edu.facisa.cwf.example5.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 688558534910932128L;
	
	@Id
	private String id;
	private String description;
	private Double value;
	
	public Product() {
	}
	
	public Product(String id, String description, Double value) {
		super();
		this.id = id;
		this.description = description;
		this.value = value;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
