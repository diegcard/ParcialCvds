package com.cvds.parcial.models;

import lombok.Getter;
import lombok.Setter;
import lombok.*;


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


}
