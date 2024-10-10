package com.finalProject.Sneakz.controller;

import com.finalProject.Sneakz.entity.Order;
import com.finalProject.Sneakz.entity.Product;
import com.finalProject.Sneakz.entity.User;
import com.finalProject.Sneakz.entity.Wishlist;
import com.finalProject.Sneakz.service.OrderService;
import com.finalProject.Sneakz.service.ProductService;
import com.finalProject.Sneakz.service.UserService;
import com.finalProject.Sneakz.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Sneakz")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<Order> createWishlistItem(@RequestBody Order order){
        long p_id= order.getProduct().getId();
        long u_id = order.getUser().getId();
        Product product = productService.findById(p_id).orElseThrow();
        User user = userService.findByUserId(u_id).orElseThrow();
        order.setProduct(product);
        order.setUser(user);
        Order _order = orderService.create(order);
        return new ResponseEntity<>(_order, HttpStatus.CREATED);
    }

    @GetMapping("/order/{user_id}")
    public ResponseEntity<List<Order>> getWishlistItemsByUserId(@PathVariable long user_id){
        return new ResponseEntity<>(orderService.findAllByUser(user_id), HttpStatus.OK);
    }
}
