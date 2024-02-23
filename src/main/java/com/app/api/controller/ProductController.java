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

    @GetMapping("/get-products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        if(products != null) return ResponseEntity.ok(products);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Product> newProduct(@RequestBody() Product product) {
        if(product == null)return ResponseEntity.badRequest().build();
        Product newProduct = productService.newProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @PostMapping("/load-products")
    public ResponseEntity<Void> loadProducts(@RequestBody() Product[] products) {
        productService.loadProducts(products);
        return ResponseEntity.ok(null);
    }
}
