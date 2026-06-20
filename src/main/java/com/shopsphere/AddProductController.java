package com.shopsphere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AddProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/add-product")
    public String addProductPage() {
        return "add-product";
    }

    @PostMapping("/save-product")
    public String saveProduct(
            @RequestParam String name,
            @RequestParam double price) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productRepository.save(product);

        return "redirect:/dashboard";
    }
}