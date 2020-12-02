package com.danielmichalski.rss.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.danielmichalski.rss.core.service.IUserService;

/**
 * Author: Daniel
 */
@Controller
@RequestMapping("/admin/users")
public class AdminController {

    private IUserService userService;

    @Autowired
    public AdminController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String showUsers(Model model) {
        model.addAttribute("usersList", userService.findAll());
        return "show-users";
    }

    @RequestMapping("{id}")
    public String userDetail(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findOneWithAllBlogs(id));
        return "user-detail";
    }

    @RequestMapping("remove-user/{id}")
    public String removeUserById(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/admin/users";
    }

}
