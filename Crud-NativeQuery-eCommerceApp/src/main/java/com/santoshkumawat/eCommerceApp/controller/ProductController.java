package com.santoshkumawat.eCommerceApp.controller;

import com.santoshkumawat.eCommerceApp.entity.Product;
import com.santoshkumawat.eCommerceApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).get();
    }

    @GetMapping("/getProductByName/{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @PostMapping
    public void addProduct(@RequestParam String name, @RequestParam Double price) {
        productService.addProduct(name, price);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}