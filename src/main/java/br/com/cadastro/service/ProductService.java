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
	
	// Get method
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
	
	// Get all method
	// Lists all the products
	public List<Product> findAll() {
		return repo.findAll();
	}
	
	// Post method
	public Product save(Product product) {
		product.setId(null);
		return repo.save(product);
	}
	
	// Put method
	public Product update(Product product) {
		Product oldProduct = this.findById(product.getId());
		this.updateProduct(oldProduct, product);
		return repo.save(oldProduct);
	}
	
	// Private method to change property values of a product to the values of
	// a updated one
	private void updateProduct(Product oldProduct, Product updatedProduct) {
		oldProduct.setName(updatedProduct.getName());
		oldProduct.setAmount(updatedProduct.getAmount());
		oldProduct.setValue(updatedProduct.getValue());
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
