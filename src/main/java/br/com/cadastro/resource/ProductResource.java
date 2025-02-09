package br.com.cadastro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.domain.Product;
import br.com.cadastro.service.ProductService;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(
		origins = "http://localhost:4200", 
		methods = {
				RequestMethod.GET, 
				RequestMethod.POST, 
				RequestMethod.PUT, 
				RequestMethod.DELETE
			},
		allowedHeaders = "*"
)
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	// Get methods
	
	// Get Method
	// by id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		Product product = service.findById(id);
		return ResponseEntity.ok().body(product);
	}
	
	// GetAll Method
	// all
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = service.findAll();
		return ResponseEntity.ok().body(products);
	}
	
	// Post Method
	
	// adds a product
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
		Product productSaved = service.save(product);
		return ResponseEntity.ok().body(productSaved);
	}
	
	// Put Method
	
	// Updated a product
	@PutMapping
	public ResponseEntity<Product> update(@RequestBody Product product) {
		Product productUpdated = service.update(product);
		return ResponseEntity.ok().body(productUpdated);
	}
	
	// Delete Method
	
	// Deletes a product
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
