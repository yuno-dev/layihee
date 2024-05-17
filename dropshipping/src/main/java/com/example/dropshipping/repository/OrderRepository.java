package com.example.dropshipping.repository;

import com.example.dropshipping.model.Order;
import com.example.dropshipping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
