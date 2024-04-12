package com.example.shoppingcart.repository;

import com.example.shoppingcart.domain.ShoppingCart;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends Neo4jRepository<ShoppingCart, Long>{
}
