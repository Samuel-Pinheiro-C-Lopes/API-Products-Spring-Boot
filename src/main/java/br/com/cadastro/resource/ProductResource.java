package br.com.cadastro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.domain.Product;
import br.com.cadastro.service.ProductService;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin("*") // not safe
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	// Get methods
	
	// Get
	// by id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		Product product = service.findById(id);
		return ResponseEntity.ok().body(product);
	}
	
	// GetAll
	// all
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = service.findAll();
		return ResponseEntity.ok().body(products);
	}
	
}
