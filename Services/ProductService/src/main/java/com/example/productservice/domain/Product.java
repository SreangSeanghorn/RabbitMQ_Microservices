package com.example.productservice.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Getter
@Setter
@Document(collection = "products")
public class Product {
    @MongoId
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
}
