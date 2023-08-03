package com.productApp.service;

import com.productApp.entities.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();

    public Product getById(int id);

    public Product addProduct(Product product);

    public Product updateProduct(int id, Product product);

    public void deleteProduct(int id);

}
