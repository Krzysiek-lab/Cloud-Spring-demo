package com.example.demo.Dtos;

import com.example.demo.Entity.ShoppingCart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CartServiceImpl {

    ResponseEntity<List<CartDto>> getCarts();

    ShoppingCart addCart(@RequestBody CartDto cartDto);

    CartDto updateCart(Long id, @RequestBody CartDto cartDto);

    void deleteCart(Long id);
}
