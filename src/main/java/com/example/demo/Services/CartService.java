package com.example.demo.Services;

import com.example.demo.Dtos.CartDto;
import com.example.demo.Dtos.CartServiceImpl;
import com.example.demo.Entity.ShoppingCart;
import com.example.demo.Mappers.CartMapper;
import com.example.demo.Repositories.CartRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartService implements CartServiceImpl {

    private final CartRepository cartRepository;
    private CartMapper cartMapper;


    @Transactional//(propagation = Propagation.SUPPORTS)
    @Override
    public ResponseEntity<List<CartDto>> getCarts() {
        return new ResponseEntity<>(cartRepository.findAll().stream()
                .map(e -> cartMapper.mapCartToDto(e)).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }

    @Override
    public ShoppingCart addCart(@RequestBody CartDto cartDto) {
        var cart = cartMapper.mapCartDtoToCart(cartDto);
        return cartRepository.save(cart);
    }

    @Override
    public CartDto updateCart(Long id, @RequestBody CartDto cartDto) {
        var cart = cartMapper.mapCartDtoToCart(cartDto);
        cart = ShoppingCart.builder()
                .id(id)
                .products(cartDto.getProducts())
                .cartName(cartDto.getCartName())
                .build();
        return cartMapper.mapCartToDto(cartRepository.save(cart));
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
