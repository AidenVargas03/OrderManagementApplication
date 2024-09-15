package com.gcu.ordermanagement.controller;

import com.gcu.ordermanagement.business.productsBusinessServiceInterface;
import com.gcu.ordermanagement.model.Product;

import java.util.*;

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
	productsBusinessServiceInterface service;
	
    @GetMapping("/display")
    public String displayProducts(Model model) {
    	//Initiate all necessary items for the page to render correctly.
    	model.addAttribute("title", "Products");
        model.addAttribute("product", new Product());
        model.addAttribute("products", service.getProducts());
        return "products";
    }

    @PostMapping("/createProduct")
    public String createProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        // Validation and registration logic here
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("title","Products");
            model.addAttribute("products",service.getProducts());
    		return "products";
    	}
    	service.insert(product);
    	//Extra caution to check that quantity is above 0 before adding to the list
    	//if(product.getProductQuantity() > 0) {
    	//products.add(product);
    	//}
    	
        return "redirect:/products/display";
    }
    
    @PostMapping("/removeProduct")
    public String removeProduct(String productId, Model model) {
        List<Product> products = service.getProducts();
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                service.deleteById(product.getId());
            }
        }
        return "redirect:/products/display";
    }

    	
        // First validate that there is an object with a matching the ID property, then remove it.
    	//products.removeIf(Product -> Product.getProductId().equals(itemId));

    }
    
    

