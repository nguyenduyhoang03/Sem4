package com.example.assignment.Controller;

import com.example.assignment.DTO.CategoryStatistic;
import com.example.assignment.DTO.ProductStatistic;
import com.example.assignment.Service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/revenue")
    public ResponseEntity<?> getTotalRevenue() {
        double totalRevenue = statisticsService.getTotalRevenue();
        return ResponseEntity.ok(Collections.singletonMap("totalRevenue", totalRevenue));
    }

    @GetMapping("/top-products")
    public ResponseEntity<?> getTopSellingProducts() {
        List<ProductStatistic> topProducts = statisticsService.getTopSellingProducts();
        return ResponseEntity.ok(topProducts);
    }

    @GetMapping("/top-categories")
    public ResponseEntity<?> getTopCategories() {
        List<CategoryStatistic> topCategories = statisticsService.getTopCategories();
        return ResponseEntity.ok(topCategories);
    }
}

