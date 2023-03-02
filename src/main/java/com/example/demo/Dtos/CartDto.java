package com.example.demo.Dtos;

import com.example.demo.Entity.Product;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CartDto {
    private Long id;
    private List<Product> products;
    @NotEmpty(message = "field can not be empty")
    private String cartName;
}
