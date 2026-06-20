package com.shopsphere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/delete-product")
    public String deleteProduct(@RequestParam Long id) {

        productRepository.deleteById(id);

        return "redirect:/products";
    }
}
