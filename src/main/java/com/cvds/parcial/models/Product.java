package com.cvds.parcial.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private String name;
    private float price;
    private int stock;
    private String category;

    /**
     * Constructor empty
     */
    public Product(){

    }

    /**
     * constructor with all parameters
     * @param name name of product
     * @param price price of product
     * @param stock stock of product
     * @param category category of product
     */
    public Product(String name, float price, int stock, String category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
