package com.gcu.ordermanagement.controller;

import com.gcu.ordermanagement.model.Product;
import com.gcu.ordermanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String displayProducts(Model model) {
        model.addAttribute("title", "Products");
        model.addAttribute("product", new Product());
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @PostMapping("/createProduct")
    public String createProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Products");
            model.addAttribute("products", productRepository.findAll());
            return "products";
        }

        if (product.getQuantity() > 0) {
            productRepository.save(product);
        }
        return "redirect:/products/";
    }

    @PostMapping("/removeProduct")
    public String removeProduct(Long itemId) {
        productRepository.deleteById(itemId);
        return "redirect:/products/";
    }
}
