package com.shopsphere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String products(
            @RequestParam(required = false) String keyword,
            Model model) {

        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute(
                    "products",
                    productRepository.findByNameContaining(keyword)
            );
        } else {
            model.addAttribute(
                    "products",
                    productRepository.findAll()
            );
        }

        return "products";
    }
}