package com.cvds.parcial.controllers;

import com.cvds.parcial.exception.ProductException;
import com.cvds.parcial.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductContoller {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable String name){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByName(name));
        }catch (ProductException.ProductDontExistsInDataBase e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product dont have exists in databse");
        } catch (ProductException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Internal Error");
        }
    }
}
