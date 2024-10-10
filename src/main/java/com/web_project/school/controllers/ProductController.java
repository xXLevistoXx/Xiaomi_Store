package com.web_project.school.controllers;

import com.web_project.school.model.ProductModel;
import com.web_project.school.service.ProductService;
import com.web_project.school.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    public ProductService productService;

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        model.addAttribute("product", new ProductModel());
        model.addAttribute("categories", categoryService.findAllCategories());
        return "productList";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.findAllProducts());
            model.addAttribute("categories", categoryService.findAllCategories());
            return "productList";
        }
        productService.addProduct(product);
        return "redirect:/products/all";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result) {
        if (result.hasErrors()) {
            return "productList";
        }
        productService.updateProduct(product);
        return "redirect:/products/all";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam UUID id) {
        productService.deleteProduct(id);
        return "redirect:/products/all";
    }

    @GetMapping("/all/{id}")
    public String getIdProduct(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("products", productService.findProductById(id));
        model.addAttribute("product", new ProductModel());
        model.addAttribute("categories", categoryService.findAllCategories());
        return "productList";
    }
}