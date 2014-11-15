package pl.dmichalski.agregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dmichalski.agregator.service.UserService;

/**
 * Author: Daniel
 */
@Controller
@RequestMapping("/users")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/{id}")
    public String deails(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findOneWithBlogs(id));
        return "user-detail";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.remove(id);
        return "redirect:/users";
    }

}
