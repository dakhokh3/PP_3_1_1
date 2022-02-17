package com.example.SpringBoot.controller;

import com.example.SpringBoot.entity.User;
import com.example.SpringBoot.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@Controller
@RequestMapping("/people")
@AllArgsConstructor
public class UsersController {
    private final UsersService userService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", userService.allUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userService.getById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") User person) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") User person) throws ValidationException {
        userService.add(person);
        return "redirect:/people/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", userService.getById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") User person, @PathVariable("id") int id) {
        userService.edit(person);
        return "redirect:/people/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/people/";
    }
}