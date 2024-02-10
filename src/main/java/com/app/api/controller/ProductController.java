package com.app.api.controller;

import com.app.api.model.Product;
import com.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService procuctService;

    @Autowired
    public ProductController(ProductService procuctService) {
        this.procuctService = procuctService;
    }

    @GetMapping("/products/get-products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = procuctService.getProducts();
        if(products != null) return ResponseEntity.ok(products);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/products/load-products")
    public ResponseEntity<Void> loadProducts(@RequestBody() Product[] products) {
        procuctService.loadProducts(products);
        return ResponseEntity.ok(null);
    }
}