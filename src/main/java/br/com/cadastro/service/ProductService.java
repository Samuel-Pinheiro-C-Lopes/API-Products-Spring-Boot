package br.com.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.domain.Product;
import br.com.cadastro.repositories.ProductRepository;
import br.com.cadastro.service.exception.ObjectNotFoundException;

@Service
// Service for the product domain
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	// Lists a product based on an id provided
	public Product findById (Integer id) {
		Optional<Product> product = repo.findById(id);
		return product.orElseThrow(
				() -> new ObjectNotFoundException(
					"Object with id: " + id + 
					" and type: " + product.getClass().getName() + 
					" was not found."
					)
				);
	}
	
	// Lists all the products
	public List<Product> findAll() {
		return repo.findAll();
;	}
	
}
