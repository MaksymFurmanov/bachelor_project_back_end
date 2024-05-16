package com.app.api.controller;

import com.app.api.model.Product;
import com.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        if (products != null) return ResponseEntity.ok(products);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Product> newProduct(@RequestBody() Product product) {
        if (product == null) return ResponseEntity.badRequest().build();
        Product newProduct = productService.newProduct(product);
        if (newProduct != null) return ResponseEntity.ok(newProduct);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        if (product == null) return ResponseEntity.badRequest().build();
        Product updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) return ResponseEntity.ok(updatedProduct);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestBody() Long productId) {
        if (productId == null) return ResponseEntity.badRequest().build();
        productService.deleteProduct(productId);
        return ResponseEntity.ok(null);
    }
}
