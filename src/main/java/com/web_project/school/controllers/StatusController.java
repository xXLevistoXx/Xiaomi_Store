package com.web_project.school.controllers;

import com.web_project.school.model.StatusModel;
import com.web_project.school.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/statuses")
public class StatusController {
    @Autowired
    public StatusService statusService;

    @GetMapping("/all")
    public String getAllStatuses(Model model) {
        model.addAttribute("statuses", statusService.findAllStatuses());
        model.addAttribute("status", new StatusModel());
        return "statusList";
    }

    @PostMapping("/add")
    public String addStatus(@Valid @ModelAttribute("status") StatusModel status, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statuses", statusService.findAllStatuses());
            return "statusList";
        }
        statusService.addStatus(status);
        return "redirect:/statuses/all";
    }

    @PostMapping("/update")
    public String updateStatus(@Valid @ModelAttribute("status") StatusModel status, BindingResult result) {
        if (result.hasErrors()) {
            return "statusList";
        }
        statusService.updateStatus(status);
        return "redirect:/statuses/all";
    }

    @PostMapping("/delete")
    public String deleteStatus(@RequestParam UUID id) {
        statusService.deleteStatus(id);
        return "redirect:/statuses/all";
    }

    @GetMapping("/all/{id}")
    public String getIdStatus(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("statuses", statusService.findStatusById(id));
        model.addAttribute("status", new StatusModel());
        return "statusList";
    }
}