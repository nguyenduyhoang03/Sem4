package com.example.assignment.Controller;

import com.example.assignment.DTO.ReviewRequest;
import com.example.assignment.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PutMapping("/{orderId}/status")
    public ResponseEntity<?> updateOrderStatus(@PathVariable Long orderId, @RequestBody Map<String, String> request) {
        String status = request.get("status");
        orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok("Order status updated successfully");
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId, @RequestBody Map<String, String> request) {
        String reason = request.get("reason");
        orderService.cancelOrder(orderId, reason);
        return ResponseEntity.ok("Order cancelled successfully");
    }

    @PostMapping("/{orderId}/review")
    public ResponseEntity<?> reviewOrder(@PathVariable Long orderId, @RequestBody ReviewRequest reviewRequest) {
        orderService.reviewOrder(orderId, reviewRequest);
        return ResponseEntity.ok("Review submitted successfully");
    }
}

