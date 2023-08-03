package com.productApp.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "product_table")
public class Product {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //i will share a video
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
