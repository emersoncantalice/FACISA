package br.edu.facisa.cwf.example5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.facisa.cwf.example5.domain.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	public Product findByDescription(String name);
	
}
