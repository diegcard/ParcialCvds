package com.cvds.parcial.services;

import com.cvds.parcial.exception.ProductException;
import com.cvds.parcial.models.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    private Map<String, Product> products;

    public ProductService(){
        products = new HashMap<>();
        Product p1 = new Product("Xbox", 45.f, 5, "Consoles");
        products.put(p1.getName(), p1);
    }

    public Product saveProduct(Product product) throws ProductException {
        if(product == null){
            throw new ProductException.ProductDontHaveNull("The product dont has null");
        }
        if(products.get(product.getName()) == null){
            throw new RuntimeException("The product already exists in data base");
        }
        return products.put(product.getName(), product);
    }


    public Map<String, Product> getAll() {
        return this.products;
    }

    public Product getProductByName(String name) throws ProductException{
        if(this.products.get(name) == null){
            throw new ProductException.ProductDontExistsInDataBase("The product dont have exists in database");
        }
        return this.products.get(name);
    }
}
