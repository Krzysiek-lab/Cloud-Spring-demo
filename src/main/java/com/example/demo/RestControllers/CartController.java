package com.example.demo.RestControllers;


import com.example.demo.Dtos.CartDto;
import com.example.demo.Entity.ShoppingCart;
import com.example.demo.Services.CartService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private CartService cartService;

    @GetMapping("/get")
    public ResponseEntity<List<CartDto>> getCarts() {
        return cartService.getCarts();
    }

    @PostMapping("/add")
    public ResponseEntity<ShoppingCart> addCart(@RequestBody @Valid CartDto cartDto) {
        return new ResponseEntity<>(cartService.addCart(cartDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/")
    public ResponseEntity<CartDto> updateCart(@RequestParam Long id, @RequestBody @Valid CartDto cartDto) {
        return new ResponseEntity<>(cartService.updateCart(id, cartDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCartsById(@PathVariable Long id) {
        cartService.deleteCart(id);
        return new ResponseEntity<>("Deleted cart with id: " + id, HttpStatus.ACCEPTED);
    }
}
