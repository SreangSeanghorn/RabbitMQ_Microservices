package com.example.productservice.service;

import com.example.productservice.domain.Product;
import com.example.productservice.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {
     ProductDTO saveProduct(ProductDTO product);
     Optional<ProductDTO> getProductById(Long id);

}
