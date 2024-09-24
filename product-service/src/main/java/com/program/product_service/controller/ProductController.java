package com.program.product_service.controller;

import com.program.product_service.productDTO.ProductRequest;
import com.program.product_service.productDTO.ProductResponse;
import com.program.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest)
    {
        return productService.createProduct(productRequest);
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts()
    {
        return productService.getAllProducts();
    }
}
