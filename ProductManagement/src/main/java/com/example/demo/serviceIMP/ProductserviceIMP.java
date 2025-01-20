package com.example.demo.serviceIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.model.Product;
import com.example.demo.serviceI.ProductServiceI;

@Service
public class ProductserviceIMP implements ProductServiceI {
	 @Autowired
	    private ProductRepository productRepository;
	 
	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public Product createProduct(Product product) {
		 return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        return productRepository.save(existingProduct);
	}

	@Override
	public void deleteProduct(Long id) {
		 productRepository.deleteById(id);
		
	}

}
