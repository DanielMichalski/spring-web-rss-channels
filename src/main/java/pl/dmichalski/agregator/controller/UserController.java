package pl.dmichalski.agregator.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmichalski.agregator.entity.User;
import pl.dmichalski.agregator.service.UserService;

/**
 * Author: Daniel
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/users/{id}")
    public String deails(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findOneWithBlogs(id));
        return "user-detail";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "user-register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user) {
        userService.save(user);
        return "user-register";
    }

}
