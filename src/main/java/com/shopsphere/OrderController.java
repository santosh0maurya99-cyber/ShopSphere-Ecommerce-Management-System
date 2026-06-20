package com.shopsphere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public String orders(Model model) {

        model.addAttribute("orders", orderRepository.findAll());

        return "orders";
    }

    @GetMapping("/add-order")
    public String addOrderPage() {
        return "add-order";
    }

    @PostMapping("/save-order")
    public String saveOrder(
            @RequestParam String customerName,
            @RequestParam String productName,
            @RequestParam double amount) {

        Order order = new Order();

        order.setCustomerName(customerName);
        order.setProductName(productName);
        order.setAmount(amount);

        orderRepository.save(order);

        return "redirect:/orders";
    }
}