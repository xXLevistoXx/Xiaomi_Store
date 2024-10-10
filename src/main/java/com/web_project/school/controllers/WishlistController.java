package com.web_project.school.controllers;

import com.web_project.school.model.WishlistModel;
import com.web_project.school.service.WishlistService;
import com.web_project.school.service.UserService;
import com.web_project.school.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/wishlists")
public class WishlistController {
    @Autowired
    public WishlistService wishlistService;

    @Autowired
    public UserService userService;

    @Autowired
    public ProductService productService;

    @GetMapping("/all")
    public String getAllWishlists(Model model) {
        model.addAttribute("wishlists", wishlistService.findAllWishlists());
        model.addAttribute("wishlist", new WishlistModel());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("products", productService.findAllProducts());
        return "wishlistList";
    }

    @PostMapping("/add")
    public String addWishlist(@Valid @ModelAttribute("wishlist") WishlistModel wishlist, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("wishlists", wishlistService.findAllWishlists());
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("products", productService.findAllProducts());
            return "wishlistList";
        }
        wishlistService.addWishlist(wishlist);
        return "redirect:/wishlists/all";
    }

    @PostMapping("/update")
    public String updateWishlist(@Valid @ModelAttribute("wishlist") WishlistModel wishlist, BindingResult result) {
        if (result.hasErrors()) {
            return "wishlistList";
        }
        wishlistService.updateWishlist(wishlist);
        return "redirect:/wishlists/all";
    }

    @PostMapping("/delete")
    public String deleteWishlist(@RequestParam UUID id) {
        wishlistService.deleteWishlist(id);
        return "redirect:/wishlists/all";
    }

    @GetMapping("/all/{id}")
    public String getIdWishlist(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("wishlists", wishlistService.findWishlistById(id));
        model.addAttribute("wishlist", new WishlistModel());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("products", productService.findAllProducts());
        return "wishlistList";
    }
}