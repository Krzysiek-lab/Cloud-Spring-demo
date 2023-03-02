package com.example.demo.RestControllers;


import com.example.demo.Dtos.ProductDto;
import com.example.demo.Entity.Product;
import com.example.demo.Services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @GetMapping("/get")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProducts(@RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/")
    public ResponseEntity<ProductDto> updateProducts(@RequestParam Long id, @RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.updateProduct(id, productDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductsById(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted product with id: " + id, HttpStatus.ACCEPTED);
    }
}
