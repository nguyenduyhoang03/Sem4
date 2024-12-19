package com.example.assignment.Repository;

import com.example.assignment.DTO.ProductStatistic;
import com.example.assignment.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new ProductStatistic(p.id, p.name, SUM(p.quantitySold)) " +
            "FROM Product p GROUP BY p.id ORDER BY SUM(p.quantitySold) DESC")
    List<ProductStatistic> findTopSellingProducts();
}

