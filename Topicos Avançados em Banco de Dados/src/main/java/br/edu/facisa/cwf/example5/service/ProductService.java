package br.edu.facisa.cwf.example5.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.edu.facisa.cwf.example5.domain.Product;
import br.edu.facisa.cwf.example5.exceptions.ProductAlreadyExistsException;
import br.edu.facisa.cwf.example5.repository.ProductRepository;

@Service
@Validated
public class ProductService {

	@Autowired
    private ProductRepository repository;
    
    public Product getById(String id) {    
    	return repository.findOne(id);
    }
    
	public List<Product> listAllProducts() {
		return repository.findAll();
	}
	
	@Transactional
	public void deleteProduct(Product product) {
		repository.delete(product);
	}
	
    @Transactional
    public Product save(@NotNull @Valid final Product product) throws Exception {
    	
        Product existing = repository.findOne(product.getId());

        if (existing != null) {
            throw new ProductAlreadyExistsException(String.format("There already exists a product wjth description=%s", product.getDescription()));
        }

        return repository.save(product);
    }

	public ProductRepository getRepository() {
		return repository;
	}

	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}
}
