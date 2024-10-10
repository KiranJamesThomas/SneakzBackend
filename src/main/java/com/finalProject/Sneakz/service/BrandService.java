package com.finalProject.Sneakz.service;

import com.finalProject.Sneakz.entity.Brand;
import com.finalProject.Sneakz.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand create(Brand brand){
        return brandRepository.save(brand);
    }

    public List<Brand> findAll(){
        return new ArrayList<>(brandRepository.findAll());
    }

    public Boolean brandExists(String brand){
        return null != brandRepository.findBrandByBrandName(brand);
    }

    public Brand brandByName(String brand){
        return brandRepository.findBrandByBrandName(brand);
    }

    public Optional<Brand> getBrandById(long id){
        return brandRepository.findById(id);
    }
}
