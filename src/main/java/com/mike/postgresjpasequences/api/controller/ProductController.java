package com.mike.postgresjpasequences.api.controller;

import com.mike.postgresjpasequences.api.Product;
import com.mike.postgresjpasequences.db.entity.ProductEntity;
import com.mike.postgresjpasequences.db.repostiory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController
{

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> allProducts() {

        List<ProductEntity> productEntities = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity: productEntities) {
            products.add(new Product(productEntity.getId(), productEntity.getTitle(),
                    productEntity.getDescription(), productEntity.getPrice()));
        }

        return products;

    }

    @PostMapping("/products")
    public Product createProduct(Product product) {

        ProductEntity productEntity = new ProductEntity(product.id(), product.title(),
                product.description(), product.price());

        ProductEntity savedProductEntity = productRepository.save(productEntity);

        Product savedProduct = new Product(savedProductEntity.getId(), savedProductEntity.getTitle(),
                savedProductEntity.getDescription(), savedProductEntity.getPrice());

        return savedProduct;
    }
}
