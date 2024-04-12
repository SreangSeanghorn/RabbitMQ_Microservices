package com.example.productservice.service.implementation;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    RabbitMQProducer rabbitMQProducer;
    @Override
    public ProductDTO saveProduct(ProductDTO product){
        rabbitMQProducer.sendMessageToQueue("testQueue",product);
        return productMapper.toProductDTO(productRepository.save(productMapper.toProduct(product)));
    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
      return productRepository.findById(id).map(productMapper::toProductDTO);
    }
}
