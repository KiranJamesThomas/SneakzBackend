package com.finalProject.Sneakz.repository;

import com.finalProject.Sneakz.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findBrandByBrandName(String brandName);

    @Query(value = "SELECT b FROM Brand b JOIN b.products p GROUP BY b.id ORDER BY COUNT(p.id) DESC")
    List<Brand> findTop5BrandsWithMostProducts();

}
