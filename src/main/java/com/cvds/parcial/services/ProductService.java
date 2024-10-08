package com.cvds.parcial.services;

import com.cvds.parcial.exception.ProductException;
import com.cvds.parcial.models.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represent the service of a products
 */
@Service
public class ProductService {
    private Map<String, Product> products;

    /**
     * Constructor of service
     */
    public ProductService(){
        products = new HashMap<>();
        /*Product p1 = new Product("Xbox", 45.4f, 5, "Consoles");
        Product p2 = new Product("Play", 74.7f, 8, "Consoles");
        saveProduct(p1);
        saveProduct(p2);*/
    }

    /**
     * Service for save the product in database
     * @param product Product
     * @return Product for response
     */
    public Product saveProduct(Product product){
        if(product == null){
            throw new RuntimeException("The product dont have null");
        }
        if(products.get(product.getName()) != null){
            throw new RuntimeException("The product already exits in the database");
        }
        products.put(product.getName(), product);
        return products.get(product.getName());
    }


    /**
     * Return de all products in database
     * @return Map<String, Product> Map of list of products
     */
    public Map<String, Product> getAll() {
        return this.products;
    }

    /**
     * Search a product by his id
     * @param name name of product
     * @return Product
     * @throws ProductException for exepcyons relacionated
     */
    public Product getProductByName(String name) throws ProductException{
        if(this.products.get(name) == null){
            throw new ProductException.ProductDontExistsInDataBase("The product dont have exists in database");
        }
        return this.products.get(name);
    }

    /**
     * this service representate of a stock of product
     * @param name name of product
     * @param stock quantity
     * @return Product
     */
    public Product updateStockProduct(String name, int stock){
        if(name == null){
            throw new RuntimeException("The name is null");
        }
        if(products.get(name) == null){
            throw new RuntimeException("The product not found in database");
        }
        products.get(name).setStock(stock);
        if (products.get(name).getStock() >= 5){
            new AgentLog().notifyAgent(products.get(name));
        }else {
            new AgentDanger().notifyAgent(products.get(name));
        }
        return products.get(name);
    }
}
