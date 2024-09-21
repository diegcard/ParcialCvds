package com.cvds.parcial.model;

import com.cvds.parcial.models.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void createProductWithAllParameters() {
        Product product = new Product("PlayStation", 499.99f, 20, "Consoles");
        assertEquals("PlayStation", product.getName());
        assertEquals(499.99f, product.getPrice());
        assertEquals(20, product.getStock());
        assertEquals("Consoles", product.getCategory());
    }

    @Test
    void createProductWithEmptyConstructor() {
        Product product = new Product();
        assertNull(product.getName());
        assertEquals(0.0f, product.getPrice());
        assertEquals(0, product.getStock());
        assertNull(product.getCategory());
    }

    @Test
    void setNameSuccessfully() {
        Product product = new Product();
        product.setName("Nintendo Switch");
        assertEquals("Nintendo Switch", product.getName());
    }
    @Test
    void setPriceSuccessfully() {
        Product product = new Product();
        product.setPrice(299.99f);
        assertEquals(299.99f, product.getPrice());
    }

    @Test
    void setStockSuccessfully() {
        Product product = new Product();
        product.setStock(15);
        assertEquals(15, product.getStock());
    }

    @Test
    void setCategorySuccessfully() {
        Product product = new Product();
        product.setCategory("Handheld Consoles");
        assertEquals("Handheld Consoles", product.getCategory());
    }
}