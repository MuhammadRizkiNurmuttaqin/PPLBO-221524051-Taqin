package com.techie.microservices.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techie.microservices.product.dto.ProductRequest;
import com.techie.microservices.product.dto.ProductResponse;
import com.techie.microservices.product.model.Product;
import com.techie.microservices.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
            .name(productRequest.name())
            .price(productRequest.price())
            .description(productRequest.description())
            .build();

        productRepository.save(product);
        log.info("Product Created Successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDescription());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
            .stream()
            .map(product -> new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDescription()))
            .toList();
    }
}
