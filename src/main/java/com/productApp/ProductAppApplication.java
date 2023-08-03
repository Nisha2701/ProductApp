package com.productApp;

import com.productApp.entities.Product;
import com.productApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductAppApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("------adding new products-----");
//		productService.addProduct(new Product("Samsung Watch",1500.00));
//		productService.addProduct(new Product("Iphone",1_00_000.00));
	}
}
