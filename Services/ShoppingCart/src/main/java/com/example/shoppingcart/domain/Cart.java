package com.example.shoppingcart.domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Node
public class Cart {
    @Id
    Long id;
    @Relationship(type = "HAS_PRODUCT")
    Product product;
    private int quantity;
}
