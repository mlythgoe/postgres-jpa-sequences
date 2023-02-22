package com.mike.postgresjpasequences.db.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "storeId")
    private Long storeId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;

    public ProductEntity() {
    }

    public ProductEntity(Long id, Long storeId, String title, String description, int price) {
        this.id = id;
        this.storeId = storeId;
        this.title = title;
        this.description = description;
        this.price = price;

    }

    public Long getId() {
        return id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
