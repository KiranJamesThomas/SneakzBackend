package com.finalProject.Sneakz.controller;

import com.finalProject.Sneakz.entity.*;
import com.finalProject.Sneakz.service.BrandService;
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
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @PostMapping("/wishlist")
    public ResponseEntity<Wishlist> createWishlistItem(@RequestBody Wishlist wishlist){
        long p_id= wishlist.getProduct().getId();
        long u_id = wishlist.getUser().getId();
        Product product = productService.findById(p_id).orElseThrow();
        User user = userService.findByUserId(u_id).orElseThrow();
        wishlist.setProduct(product);
        wishlist.setUser(user);
        Wishlist _wishlist = wishlistService.create(wishlist);
        return new ResponseEntity<>(_wishlist, HttpStatus.CREATED);
    }

    @GetMapping("/wishlist/{user_id}")
    public ResponseEntity<List<Wishlist>> getWishlistItemsByUserId(@PathVariable long user_id){
        return new ResponseEntity<>(wishlistService.findAllByUser(user_id), HttpStatus.OK);
    }
}
