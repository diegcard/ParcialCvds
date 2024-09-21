package com.cvds.parcial.service;

import com.cvds.parcial.exception.ProductException;
import com.cvds.parcial.models.Product;
import com.cvds.parcial.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void saveProductSuccessfully() {
        Product product = new Product("Switch", 299.99f, 10, "Consoles");
        Product savedProduct = productService.saveProduct(product);
        assertEquals(product, savedProduct);
    }

    @Test
    void saveProductThrowsExceptionWhenProductIsNull() {
        assertThrows(RuntimeException.class, () -> productService.saveProduct(null));
    }

    @Test
    void getProductByNameThrowsExceptionWhenProductDoesNotExist() {
        assertThrows(ProductException.ProductDontExistsInDataBase.class, () -> productService.getProductByName("NonExistentProduct"));
    }


    @Test
    void updateStockProductThrowsExceptionWhenNameIsNull() {
        assertThrows(RuntimeException.class, () -> productService.updateStockProduct(null, 10));
    }

    @Test
    void updateStockProductThrowsExceptionWhenProductDoesNotExist() {
        assertThrows(RuntimeException.class, () -> productService.updateStockProduct("NonExistentProduct", 10));
    }

    @Test
    void getAllProducts(){
        Product product = new Product("Switch", 299.99f, 10, "Consoles");
        productService.saveProduct(product);
        Map<String, Product> actual =  productService.getAll();
        Map<String, Product> expected =  new HashMap<>();
        expected.put(product.getName(), product);
        assertEquals(expected, expected);
    }

    @Test
    void saveProductInDataBaseAlreadyExits(){
        Product product1 = new Product("Switch", 299.99f, 10, "Consoles");
        Product product2 = new Product("Switch", 299.99f, 10, "Consoles");
        Product savedProduct1 = productService.saveProduct(product1);
        assertThrows(RuntimeException.class, () -> productService.saveProduct(product2));
    }

    @Test
    void getProductById() throws ProductException {
        Product product1 = new Product("Switch", 299.99f, 10, "Consoles");
        productService.saveProduct(product1);
        Product pro = productService.getProductByName(product1.getName());
        assertEquals(product1, pro);
    }

    @Test
    void getAgentsLog(){
        Product product1 = new Product("Switch", 299.99f, 10, "Consoles");
        productService.saveProduct(product1);
        assertEquals(productService.updateStockProduct(product1.getName(), 45),product1);
    }

    @Test
    void getAgentsDangerousLog(){
        Product product1 = new Product("Switch", 299.99f, 10, "Consoles");
        productService.saveProduct(product1);
        assertEquals(productService.updateStockProduct(product1.getName(), 1),product1);
    }

}