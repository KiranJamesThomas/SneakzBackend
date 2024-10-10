package com.finalProject.Sneakz.repository;

import com.finalProject.Sneakz.entity.Cart;
import com.finalProject.Sneakz.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findByUserId(Long userId);
}
