package com.gcu.ordermanagement.controller;

import com.gcu.ordermanagement.model.Products;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private List<Products> products = new ArrayList<>();

    @GetMapping("/")
    public String displayProducts(Model model) {
        model.addAttribute("title", "Products");
        model.addAttribute("product", new Products());
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/createProduct")
    public String createProduct(@Valid Products product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Products");
            model.addAttribute("products", products);
            return "products";
        }

        if (product.getProductQuantity() > 0) {
            products.add(product);
        }
        return "redirect:/products/";
    }

    @PostMapping("/removeProduct")
    public String removeProduct(Long itemId) {
        products.removeIf(product -> product.getProductId().equals(itemId));
        return "redirect:/products/";
    }
}
