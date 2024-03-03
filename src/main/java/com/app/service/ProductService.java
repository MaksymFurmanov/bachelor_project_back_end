package com.app.service;

import com.app.api.model.Product;
import com.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product newProduct (Product product) {
        Product savedProduct = productRepository.save(product);
        return productRepository.findById(savedProduct.getProduct_id()).orElse(null);
    }

    public List<Product> loadProducts(Product[] products) {
        return productRepository.saveAll(Arrays.asList(products));
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteAllById(Collections.singleton(productId));
    }
}
