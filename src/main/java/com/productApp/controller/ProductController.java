package com.productApp.controller;

import com.productApp.entities.Product;
import com.productApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path="products")
    public ResponseEntity<List<Product>> getAll(){
        System.out.println(productService.getClass());
//        if(1==1)
//            throw new RuntimeException("some db error");
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping(path="products/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        return ResponseEntity.ok().body(productService.getById(id));
    }

    @PostMapping(path="products")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        Product addedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("product added successfully and auto generated the key:"+addedProduct.getId());
    }

    @PutMapping(path="products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestBody Product product){
        Product productUpdated = productService.updateProduct(id,product);
        return ResponseEntity.ok().body("product with id"+id+"is updated successfully");
    }

    @DeleteMapping(path="products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
