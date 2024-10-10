package com.finalProject.Sneakz.service;

import com.finalProject.Sneakz.entity.Order;
import com.finalProject.Sneakz.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order create(Order order){
        return orderRepository.save(order);
    }

    public List<Order> findAll(){
        return new ArrayList<>(orderRepository.findAll());
    }

    public List<Order> findAllByUser(long id){
        return new ArrayList<>(orderRepository.findByUserId(id));
    }

}
