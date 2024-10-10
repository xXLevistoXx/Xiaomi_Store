package com.web_project.school.controllers;

import com.web_project.school.model.OrderModel;
import com.web_project.school.service.OrderService;
import com.web_project.school.service.UserService;
import com.web_project.school.service.StatusService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderService orderService;

    @Autowired
    public UserService userService;

    @Autowired
    public StatusService statusService;

    @GetMapping("/all")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.findAllOrders());
        model.addAttribute("order", new OrderModel());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("statuses", statusService.findAllStatuses());
        return "orderList";
    }

    @PostMapping("/add")
    public String addOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("orders", orderService.findAllOrders());
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("statuses", statusService.findAllStatuses());
            return "orderList";
        }
        logger.info("Adding order: {}", order);
        orderService.addOrder(order);
        return "redirect:/orders/all";
    }

    @PostMapping("/update")
    public String updateOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result) {
        if (result.hasErrors()) {
            return "orderList";
        }
        logger.info("Updating order: {}", order);
        orderService.updateOrder(order);
        return "redirect:/orders/all";
    }

    @PostMapping("/delete")
    public String deleteOrder(@RequestParam UUID id) {
        logger.info("Deleting order with id: {}", id);
        orderService.deleteOrder(id);
        return "redirect:/orders/all";
    }

    @GetMapping("/all/{id}")
    public String getIdOrder(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("orders", orderService.findOrderById(id));
        model.addAttribute("order", new OrderModel());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("statuses", statusService.findAllStatuses());
        return "orderList";
    }
}