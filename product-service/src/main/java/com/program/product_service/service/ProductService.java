package com.program.product_service.service;

import com.program.product_service.model.Product;
import com.program.product_service.productDTO.ProductRequest;
import com.program.product_service.productDTO.ProductResponse;
import com.program.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<String> createProduct(ProductRequest productRequest) {
        Product product=new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products=productRepository.findAll();
        // now convert the product class to productResponse class
        //products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
        List<ProductResponse> pdtRes=products.stream().map(this::mapToProductResponse).toList();
        return new ResponseEntity<>(pdtRes, HttpStatus.OK);
    }

    private ProductResponse mapToProductResponse(Product product) {
        ProductResponse productResponse=new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
}
