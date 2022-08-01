package com.organisation.WmStore.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String productName;
    private String country;
    private String price;
    private String imageProduct;

    public Product() {

    }

    public Product(Long id, String productName, String country, String price, String imageProduct) {
        this.id = id;
        this.productName = productName;
        this.country = country;
        this.price = price;
        this.imageProduct = imageProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", country='" + country + '\'' +
                ", price='" + price + '\'' +
                ", imageProduct='" + imageProduct + '\'' +
                '}';
    }
}
