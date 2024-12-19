package com.example.assignment.Service;

import com.example.assignment.DTO.CategoryStatistic;
import com.example.assignment.DTO.ProductStatistic;
import com.example.assignment.Entity.OrderStatus;
import com.example.assignment.Repository.CategoryRepository;
import com.example.assignment.Repository.OrderRepository;
import com.example.assignment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.assignment.Entity.Order;

import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public double getTotalRevenue() {
        return orderRepository.findAllByStatus(OrderStatus.DELIVERED)
                .stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }

    public List<ProductStatistic> getTopSellingProducts() {
        return productRepository.findTopSellingProducts();
    }

    public List<CategoryStatistic> getTopCategories() {
        return categoryRepository.findTopCategoriesByRevenue();
    }
}

