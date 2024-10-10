package com.web_project.school.controllers;

import com.web_project.school.model.OrderItemModel;
import com.web_project.school.service.OrderItemService;
import com.web_project.school.service.OrderService;
import com.web_project.school.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/orderItems")
public class OrderItemController {
    @Autowired
    public OrderItemService orderItemService;

    @Autowired
    public OrderService orderService;

    @Autowired
    public ProductService productService;

    @GetMapping("/all")
    public String getAllOrderItems(Model model) {
        model.addAttribute("orderItems", orderItemService.findAllOrderItems());
        model.addAttribute("orderItem", new OrderItemModel());
        model.addAttribute("orders", orderService.findAllOrders());
        model.addAttribute("products", productService.findAllProducts());
        return "orderItemList";
    }

    @PostMapping("/add")
    public String addOrderItem(@Valid @ModelAttribute("orderItem") OrderItemModel orderItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("orderItems", orderItemService.findAllOrderItems());
            model.addAttribute("orders", orderService.findAllOrders());
            model.addAttribute("products", productService.findAllProducts());
            return "orderItemList";
        }
        orderItemService.addOrderItem(orderItem);
        return "redirect:/orderItems/all";
    }

    @PostMapping("/update")
    public String updateOrderItem(@Valid @ModelAttribute("orderItem") OrderItemModel orderItem, BindingResult result) {
        if (result.hasErrors()) {
            return "orderItemList";
        }
        orderItemService.updateOrderItem(orderItem);
        return "redirect:/orderItems/all";
    }

    @PostMapping("/delete")
    public String deleteOrderItem(@RequestParam UUID id) {
        orderItemService.deleteOrderItem(id);
        return "redirect:/orderItems/all";
    }

    @GetMapping("/all/{id}")
    public String getIdOrderItem(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("orderItems", orderItemService.findOrderItemById(id));
        model.addAttribute("orderItem", new OrderItemModel());
        model.addAttribute("orders", orderService.findAllOrders());
        model.addAttribute("products", productService.findAllProducts());
        return "orderItemList";
    }
}