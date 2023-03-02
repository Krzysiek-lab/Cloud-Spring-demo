package com.example.demo.Dtos;

import com.example.demo.Entity.ShoppingCart;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class ProductDto {
    private Long id;
    private ShoppingCart cart;

    @NotEmpty(message = "field can not be empty")
    private String name;

    @DecimalMax("1000")
    @DecimalMin("10")
    private BigDecimal price;
}
