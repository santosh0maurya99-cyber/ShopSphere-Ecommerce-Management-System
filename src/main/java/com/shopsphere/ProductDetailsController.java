package com.shopsphere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductDetailsController {

    @GetMapping("/product-details")
    public String productDetails() {
        return "product-details";
    }
}
