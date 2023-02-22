package com.mike.postgresjpasequences.api.controller;

import com.mike.postgresjpasequences.api.Product;
import com.mike.postgresjpasequences.db.entity.ProductEntity;
import com.mike.postgresjpasequences.db.repostiory.CustomProductRepository;
import com.mike.postgresjpasequences.db.repostiory.ProductRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(path = "/products")

public class ProductController {
    ProductRepository productRepository;
    CustomProductRepository customProductRepository;

    public ProductController(ProductRepository productRepository,
                             CustomProductRepository customProductRepository) {
        this.productRepository = productRepository;
        this.customProductRepository = customProductRepository;
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<Product> allProducts() {

        List<ProductEntity> productEntities = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            products.add(new Product(productEntity.getId(), productEntity.getStoreId(),
                    productEntity.getTitle(),
                    productEntity.getDescription(), productEntity.getPrice()));
        }

        return products;

    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    @Transactional(propagation = Propagation.REQUIRED)
    public Product createProduct(@RequestBody Product product) {

        System.out.println("Create product" + product);
        Long productId = null;
        try {
            productId = productRepository.getNextSequenceValueForStore(product.storeId());

        } catch (Exception t) {
            System.out.println("creating and using sequence");
            productRepository.createSequenceForStore(product.storeId());
            productId = productRepository.getNextSequenceValueForStore(product.storeId());

        }
        ProductEntity productEntity = new ProductEntity(productId, product.storeId(),
                product.title(), product.description(), product.price());

        ProductEntity savedProductEntity = productRepository.save(productEntity);

        return new Product(savedProductEntity.getId(), savedProductEntity.getStoreId(),
                savedProductEntity.getTitle(),
                savedProductEntity.getDescription(), savedProductEntity.getPrice());
    }
}
