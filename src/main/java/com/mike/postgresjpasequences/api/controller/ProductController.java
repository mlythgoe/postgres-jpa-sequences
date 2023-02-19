package com.mike.postgresjpasequences.controller;

import com.mike.postgresjpasequences.db.entity.ProductEntity;
import com.mike.postgresjpasequences.db.repostiory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController
{

    @Autowired
    ProductRepository productRepository;
    @GetMapping("/products")
    public List<ProductEntity> allProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public List<ProductEntity> createPrduct(Product product) {
        return productRepository.save();
    }
}
