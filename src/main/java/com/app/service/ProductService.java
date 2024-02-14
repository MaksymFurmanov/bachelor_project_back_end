package com.app.service;

import com.app.api.model.Product;
import com.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public void newProduct (Product product) {
        productRepository.save(product);
    }

    public void loadProducts(Product[] products) {
        productRepository.saveAll(Arrays.asList(products));
    }
}
