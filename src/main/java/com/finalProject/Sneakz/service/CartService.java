package com.finalProject.Sneakz.service;

import com.finalProject.Sneakz.entity.Cart;
import com.finalProject.Sneakz.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart create(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> findAllByUser(long id){
        return new ArrayList<>(cartRepository.findByUserId(id));
    }
}
