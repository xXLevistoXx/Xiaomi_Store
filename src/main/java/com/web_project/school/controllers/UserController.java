package com.web_project.school.controllers;

import com.web_project.school.model.UserModel;
import com.web_project.school.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("user", new UserModel());
        return "userList";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("user") UserModel user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAllUsers());
            return "userList";
        }
        userService.addUser(user);
        return "redirect:/users/all";
    }

    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("user") UserModel user, BindingResult result) {
        if (result.hasErrors()) {
            return "userList";
        }
        userService.updateUser(user);
        return "redirect:/users/all";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam UUID id) {
        userService.deleteUser(id);
        return "redirect:/users/all";
    }

    @GetMapping("/all/{id}")
    public String getIdUser(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("users", userService.findUserById(id));
        model.addAttribute("user", new UserModel());
        return "userList";
    }
}