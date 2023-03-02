package com.example.demo.Mappers;

import com.example.demo.Dtos.ProductDto;
import com.example.demo.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto mapProductsToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .cart(product.getCart())
                .price(product.getPrice())
                .name(product.getName())
                .build();
    }

    public Product mapProductDtoToProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .cart(productDto.getCart())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
    }
}
