package com.example.shoppingcart.domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Node
public class ShoppingCart {
    @Id
    private Long id;
    @Relationship(type = "HAS_CART")
   ArrayList<Cart> carts = new ArrayList<>();
   public void addToCart(Product product, int quantity){
       for(Cart cart: carts){
           if(cart.getProduct().getId().equals(product.getId())){
               cart.setQuantity(cart.getQuantity() + quantity);
               return;
           }
       }
         Cart cart = new Cart();
         cart.setProduct(product);
         cart.setQuantity(quantity);
         carts.add(cart);
   }
   public double getTotalPrice(){
       double totalPrice = 0.0;
       for(Cart cart: carts){
           totalPrice = totalPrice + (cart.getProduct().getPrice() * cart.getQuantity());
       }
       return totalPrice;
   }
}
