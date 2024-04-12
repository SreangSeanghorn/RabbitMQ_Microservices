package com.example.shoppingcart.domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
}
