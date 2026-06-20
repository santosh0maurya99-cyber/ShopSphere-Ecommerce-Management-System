package com.shopsphere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EditProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/edit-product")
    public String editProduct(@RequestParam Long id, Model model) {

        Product product = productRepository.findById(id).orElse(null);

        model.addAttribute("product", product);

        return "edit-product";
    }

    @PostMapping("/update-product")
    public String updateProduct(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam double price) {

        Product product = productRepository.findById(id).orElse(null);

        if (product != null) {
            product.setName(name);
            product.setPrice(price);

            productRepository.save(product);
        }

        return "redirect:/products";
    }
}