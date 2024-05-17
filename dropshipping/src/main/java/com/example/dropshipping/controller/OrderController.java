package com.example.dropshipping.controller;

import com.example.dropshipping.model.Order;
import com.example.dropshipping.model.Product;
import com.example.dropshipping.model.User;
import com.example.dropshipping.service.OrderService;
import com.example.dropshipping.service.ProductService;
import com.example.dropshipping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/orders")
    public String getOrders(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/order/new")
    public String newOrder(Model model) {
        List<Product> products = productService.getAllProducts(); // Değiştirildi
        model.addAttribute("products", products);
        model.addAttribute("order", new Order());
        return "order_form";
    }

    @PostMapping("/order/save")
    public String saveOrder(@ModelAttribute("order") Order order, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        order.setUser(user);
        orderService.save(order);
        return "redirect:/orders";
    }
}
