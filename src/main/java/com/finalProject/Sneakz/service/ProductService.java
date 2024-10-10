package com.finalProject.Sneakz.service;

import com.finalProject.Sneakz.entity.Product;
import com.finalProject.Sneakz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){

        List<Product> list = new ArrayList<>(productRepository.findAll());
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()){
            Product p = itr.next();
            System.out.println(p.getId() + " " +p.getPrice()+" "+p.getBrand().getBrandName()+" "+p.getBrand().getId()+" "+p.getName());
        }
        return new ArrayList<>(productRepository.findAll());
    }


    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }

    public List<Product> findByName(String name){
        return productRepository.findByNameContaining(name);
    }

    public Product update(Product productToUpdate){
        return productRepository.save(productToUpdate);
    }

    public void delete(long id){
        productRepository.deleteById(id);
    }
}
