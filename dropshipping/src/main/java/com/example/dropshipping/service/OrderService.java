package com.example.dropshipping.service;

import com.example.dropshipping.model.Order;
import com.example.dropshipping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Tüm siparişleri getir
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    // Bir siparişi ID'ye göre getir
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Bir siparişi kaydet
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    // Bir siparişi sil
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
