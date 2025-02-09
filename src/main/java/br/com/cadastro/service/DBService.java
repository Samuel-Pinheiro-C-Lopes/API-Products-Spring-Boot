package br.com.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.domain.Product;
import br.com.cadastro.repositories.ProductRepository;

@Service
public class DBService {
	
	@Autowired
	private ProductRepository repo;
	
	public void initializeDataBase() {
		Product product = new Product(null, "shirt", 2, 30.5);
		repo.save(product);
	}
}
