package com.example.demo.serviceI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Product;

public interface ProductServiceI {

	Product getProductById(Long id);

	Page<Product> getAllProducts(Pageable pageable);

	Product createProduct(Product product);

	Product updateProduct(Long id, Product product);

	void deleteProduct(Long id);

}
