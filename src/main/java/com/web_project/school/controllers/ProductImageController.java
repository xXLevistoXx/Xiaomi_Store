package com.web_project.school.controllers;

import com.web_project.school.model.ProductImageModel;
import com.web_project.school.service.ProductImageService;
import com.web_project.school.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/product-images")
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public String getAllProductImages(Model model) {
        model.addAttribute("productImages", productImageService.findAllProductImages());
        model.addAttribute("productImage", new ProductImageModel());
        model.addAttribute("products", productService.findAllProducts());
        return "productImageList";
    }

    @PostMapping("/add")
    public String addProductImage(@Valid @ModelAttribute("productImage") ProductImageModel productImage, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productImages", productImageService.findAllProductImages());
            model.addAttribute("products", productService.findAllProducts());
            return "productImageList";
        }
        productImageService.addProductImage(productImage);
        return "redirect:/product-images/all";
    }

    @PostMapping("/update")
    public String updateProductImage(@Valid @ModelAttribute("productImage") ProductImageModel productImage, BindingResult result) {
        if (result.hasErrors()) {
            return "productImageList";
        }
        productImageService.updateProductImage(productImage);
        return "redirect:/product-images/all";
    }

    @PostMapping("/delete")
    public String deleteProductImage(@RequestParam UUID id) {
        productImageService.deleteProductImage(id);
        return "redirect:/product-images/all";
    }

    @GetMapping("/all/{id}")
    public String getIdProductImage(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("productImages", productImageService.findProductImageById(id));
        model.addAttribute("productImage", new ProductImageModel());
        model.addAttribute("products", productService.findAllProducts());
        return "productImageList";
    }
}