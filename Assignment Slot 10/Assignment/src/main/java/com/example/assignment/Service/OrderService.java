package com.example.assignment.Service;

import com.example.assignment.DTO.ReviewRequest;
import com.example.assignment.Entity.Order;
import com.example.assignment.Entity.OrderStatus;
import com.example.assignment.Entity.Review;
import com.example.assignment.Repository.OrderRepository;
import com.example.assignment.Repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public void updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        order.setStatus(OrderStatus.valueOf(status));
        orderRepository.save(order);
    }

    public void cancelOrder(Long orderId, String reason) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        if (!order.getStatus().equals(OrderStatus.PENDING)) {
            throw new IllegalStateException("Only PENDING orders can be cancelled");
        }
        order.setStatus(OrderStatus.CANCELLED);
        order.setCancelReason(reason);
        orderRepository.save(order);
    }

    public void reviewOrder(Long orderId, ReviewRequest reviewRequest) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        if (!order.getStatus().equals(OrderStatus.DELIVERED)) {
            throw new IllegalStateException("Only DELIVERED orders can be reviewed");
        }
        Review review = new Review();
        review.setOrder(order);
        review.setRating(reviewRequest.getRating());
        review.setComment(reviewRequest.getComment());
        reviewRepository.save(review);
    }
}

