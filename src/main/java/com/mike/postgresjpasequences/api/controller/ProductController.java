package com.mike.postgresjpasequences.api.controller;

import com.mike.postgresjpasequences.api.Product;
import com.mike.postgresjpasequences.db.entity.ProductEntity;
import com.mike.postgresjpasequences.db.repostiory.CustomProductRepository;
import com.mike.postgresjpasequences.db.repostiory.ProductRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(path = "/products")

public class ProductController
{
    ProductRepository productRepository;

    CustomProductRepository customProductRepository;

    public ProductController(ProductRepository productRepository,
                             CustomProductRepository customProductRepository) {
        this.productRepository = productRepository;
        this.customProductRepository = customProductRepository;
    }

    @GetMapping(path="/", produces = "application/json")
    public List<Product> allProducts() {

        List<ProductEntity> productEntities = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity: productEntities) {
            products.add(new Product( productEntity.getId(), productEntity.getStoreId(),
                    productEntity.getTitle(),
                    productEntity.getDescription(), productEntity.getPrice()));
        }

        return products;

    }

    @Transactional
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public Product createProduct(@RequestBody Product product) {


        System.out.println("Create product" + product);

        var productId = customProductRepository.getNextProductId(product.storeId());

        ProductEntity productEntity = new ProductEntity(productId, product.storeId(),
                product.title(),  product.description(), product.price());

        ProductEntity savedProductEntity = productRepository.save(productEntity);

        return new Product(savedProductEntity.getId(), savedProductEntity.getStoreId(),
                savedProductEntity.getTitle(),
                savedProductEntity.getDescription(), savedProductEntity.getPrice());
    }
}
