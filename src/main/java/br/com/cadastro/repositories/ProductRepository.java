package br.com.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.domain.Product;

// Communication between domain and database
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
