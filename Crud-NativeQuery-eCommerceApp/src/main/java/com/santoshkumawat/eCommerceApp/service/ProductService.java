package com.santoshkumawat.eCommerceApp.service;

import com.santoshkumawat.eCommerceApp.entity.Product;
import com.santoshkumawat.eCommerceApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Transactional
    public void addProduct(String name, Double price) {
        productRepository.addProduct(name, price);
    }

    @Transactional
    public void updateProduct(Long id, Product product) {
        productRepository.updateProduct(id, product.getName(), product.getPrice());
    }

    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }
}
