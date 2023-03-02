package com.example.demo.Dtos;

import com.example.demo.Entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductServiceImpl {

    ResponseEntity<List<ProductDto>> getProducts();

    Product addProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}
