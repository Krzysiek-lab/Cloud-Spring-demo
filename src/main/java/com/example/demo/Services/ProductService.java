package com.example.demo.Services;

import com.example.demo.Dtos.ProductDto;
import com.example.demo.Dtos.ProductServiceImpl;
import com.example.demo.Entity.Product;
import com.example.demo.Mappers.ProductMapper;
import com.example.demo.Repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService implements ProductServiceImpl {


    private final ProductRepository productRepository;
    private ProductMapper productMapper;

    @Override
    public ResponseEntity<List<ProductDto>> getProducts() {
        return new ResponseEntity<>(productRepository.findAll().stream()
                .map(e -> productMapper.mapProductsToDto(e)).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }

    @Override
    public Product addProduct(@RequestBody ProductDto productDto) {
        var product = productMapper.mapProductDtoToProduct(productDto);
        return productRepository.save(product);
    }

    @Override
    public ProductDto updateProduct(Long id, @RequestBody ProductDto productDto) {
        var foundProduct = productRepository.getReferenceById(id);
        foundProduct = Product.builder()
                .id(id)
                .cart(productDto.getCart())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
        productRepository.save(foundProduct);
        return productMapper.mapProductsToDto(foundProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
