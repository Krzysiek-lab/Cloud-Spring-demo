package com.example.demo.Mappers;

import com.example.demo.Dtos.CartDto;
import com.example.demo.Entity.ShoppingCart;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public CartDto mapCartToDto(ShoppingCart shoppingCart) {
        return CartDto.builder()
                .id(shoppingCart.getId())
                .products(shoppingCart.getProducts())
                .cartName(shoppingCart.getCartName())
                .build();
    }

    public ShoppingCart mapCartDtoToCart(CartDto cartDto) {
        return ShoppingCart.builder()
                .id(cartDto.getId())
                .products(cartDto.getProducts())
                .cartName(cartDto.getCartName())
                .build();
    }
}
