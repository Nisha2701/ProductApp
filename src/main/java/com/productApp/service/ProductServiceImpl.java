package com.productApp.service;

import com.productApp.entities.Product;
import com.productApp.exceptions.ProductNotFoundException;
import com.productApp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getById(int id) {
        Product product = productRepo.findById(id).orElseThrow(()->
                new ProductNotFoundException("product with Id"+id+"does not exist"));
        return product;
    }

    @Override
    public Product addProduct(Product product) {
        productRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product productToUpdate = getById(id);
        productToUpdate.setPrice(product.getPrice());
        productRepo.save(productToUpdate);
        return productToUpdate;
    }

    @Override
    public void deleteProduct(int id) {
        Product productToDelete = getById(id);
        productRepo.delete(productToDelete);
    }
}
