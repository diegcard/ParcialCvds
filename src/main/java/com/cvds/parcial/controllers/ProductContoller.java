package com.cvds.parcial.controllers;

import com.cvds.parcial.exception.ProductException;
import com.cvds.parcial.models.Product;
import com.cvds.parcial.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductContoller {
    /**
     * Service implementated for this class
     */
    @Autowired
    private ProductService productService;

    /**
     * Rest for get all products
     * @return Response with data
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    /**
     * Get product By name
     * @param name name of products
     * @return Response with data
     */
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

    /**
     * Save product in databse
     * @param product Product
     * @return Response entity with confirmation
     */
    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productService.saveProduct(product));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Internal Error ");
        }
    }

    /**
     * this method used by update de stock og the specific product
     * @param name name of product
     * @param stock quantity
     * @return Entity
     */
    @PutMapping("/update/{name}/{stock}")
    public ResponseEntity<?> updateProduct(@PathVariable String name, @PathVariable int stock){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productService.updateStockProduct(name, stock));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);

        }
    }


}
