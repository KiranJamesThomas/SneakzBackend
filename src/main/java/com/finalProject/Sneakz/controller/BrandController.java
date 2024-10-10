package com.finalProject.Sneakz.controller;

import com.finalProject.Sneakz.entity.Brand;
import com.finalProject.Sneakz.entity.Product;
import com.finalProject.Sneakz.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Sneakz")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/brand")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand){
        Brand brand1  = brandService.create(brand);
        return new ResponseEntity<>(brand1, HttpStatus.CREATED);
    }

    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> getAllBrands(){
        return new ResponseEntity<>(brandService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/brand/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable long id){
        return new ResponseEntity<>(brandService.getBrandById(id).orElseThrow(), HttpStatus.OK);
    }
}
