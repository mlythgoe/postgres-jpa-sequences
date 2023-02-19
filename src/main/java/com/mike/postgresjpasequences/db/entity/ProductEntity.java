package com.mike.postgresjpasequences.db.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    private int id;
    @Column(name = "storeId")
    private int storeId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;

    public ProductEntity() {
    }

    public ProductEntity(Integer storeId, String title, String description, int price) {
        this.storeId = storeId;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public ProductEntity(Integer id, Integer storeId, String title, String description, int price) {
        this.id = id;
        this.storeId = storeId;
        this.title = title;
        this.description = description;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public int getStoreId() {
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
