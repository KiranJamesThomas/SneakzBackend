package com.finalProject.Sneakz.controller;

import com.finalProject.Sneakz.entity.Cart;
import com.finalProject.Sneakz.entity.Product;
import com.finalProject.Sneakz.entity.User;
import com.finalProject.Sneakz.service.CartService;
import com.finalProject.Sneakz.service.ProductService;
import com.finalProject.Sneakz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Sneakz")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @PostMapping("/cart")
    public ResponseEntity<Cart> createImage(@RequestBody Cart cart){
        long p_id= cart.getProduct().getId();
        long u_id = cart.getUser().getId();
        Product product = productService.findById(p_id).orElseThrow();
        User user = userService.findByUserId(u_id).orElseThrow();
        cart.setProduct(product);
        cart.setUser(user);
        Cart _cart  = cartService.create(cart);
        return new ResponseEntity<>(_cart, HttpStatus.CREATED);
    }

    @GetMapping("/cart/{user_id}")
    public ResponseEntity<List<Cart>> getCartItemsByUserId(@PathVariable long user_id){
        return new ResponseEntity<>(cartService.findAllByUser(user_id), HttpStatus.OK);
    }
}

