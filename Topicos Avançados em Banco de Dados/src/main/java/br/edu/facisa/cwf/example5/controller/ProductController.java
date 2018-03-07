package br.edu.facisa.cwf.example5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.facisa.cwf.example5.domain.Product;
import br.edu.facisa.cwf.example5.service.ProductService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Fetch all products")
	public ResponseEntity<List<Product>> listAllProducts() {

		List<Product> listaUsuarios = service.listAllProducts();

		HttpStatus status;

		status = listaUsuarios != null && !listaUsuarios.isEmpty() 
				? HttpStatus.OK : HttpStatus.NOT_FOUND;

		return new ResponseEntity<List<Product>>(listaUsuarios, status);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Fetch one product")
	public ResponseEntity<Product> getProduct(@PathVariable String id) {

		Product product = service.getById(id);

		return product == null ? new ResponseEntity<Product>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create product")
	public ResponseEntity<String> createProduct(@RequestBody Product product) {

		HttpStatus status;
		
		try {
			service.save(product);
			status = HttpStatus.CREATED;

		} catch (Exception e) {
			e.printStackTrace();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<String>(status);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete product")
	public ResponseEntity<String> deleteProduct(@RequestBody Product product) {

		HttpStatus status;
		
		try {
			service.deleteProduct(product);
			status = HttpStatus.OK;

		} catch (Exception e) {
			e.printStackTrace();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<String>(status);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "Edit product")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {

		HttpStatus status;
		
		try {
			service.save(product);
			status = HttpStatus.OK;

		} catch (Exception e) {
			e.printStackTrace();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<String>(status);
	}

	public ProductService getProductService() {
		return service;
	}
}
