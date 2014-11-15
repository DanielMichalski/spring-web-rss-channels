package pl.dmichalski.agregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmichalski.agregator.entity.Blog;
import pl.dmichalski.agregator.entity.User;
import pl.dmichalski.agregator.service.BlogService;
import pl.dmichalski.agregator.service.UserService;

import java.security.Principal;

/**
 * Author: Daniel
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

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
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:register?success=true";
    }

    @RequestMapping("/account")
    public String account(Model model, Principal principal){
        String userName = principal.getName();
        model.addAttribute("blog", new Blog());
        model.addAttribute("user", userService.findOneWithBlogs(userName));
        return "user-detail";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal) {
        String name = principal.getName();
        blogService.save(blog, name);
        return "redirect:/account";
    }

    @RequestMapping(value = "/blog/remove/{id}")
    public String removeBlog(@PathVariable Long id) {
        Blog blog = blogService.findOne(id);
        blogService.delete(blog);
        return "redirect:/account";
    }

    @RequestMapping("/users/remove/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.remove(id);
        return "redirect:/users";
    }

}
