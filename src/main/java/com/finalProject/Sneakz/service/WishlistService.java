package com.finalProject.Sneakz.service;

import com.finalProject.Sneakz.entity.Brand;
import com.finalProject.Sneakz.entity.Cart;
import com.finalProject.Sneakz.entity.Wishlist;
import com.finalProject.Sneakz.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist create(Wishlist wishlist){
        return wishlistRepository.save(wishlist);
    }

    public List<Wishlist> findAll(){
        return new ArrayList<>(wishlistRepository.findAll());
    }

    public List<Wishlist> findAllByUser(long id){
        return new ArrayList<>(wishlistRepository.findByUserId(id));
    }
}
