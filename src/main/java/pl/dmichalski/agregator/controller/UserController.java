package pl.dmichalski.agregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmichalski.agregator.entity.Blog;
import pl.dmichalski.agregator.entity.User;
import pl.dmichalski.agregator.service.BlogService;
import pl.dmichalski.agregator.service.UserService;

import javax.validation.Valid;
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

    @RequestMapping("/account")
    public String account(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("blog", new Blog());
        model.addAttribute("user", userService.findOneWithBlogs(userName));
        return "account";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddBlog(@Valid @ModelAttribute("blog") Blog blog, Model model,
                            Principal principal, BindingResult result) {
        if (result.hasErrors()) {
            return account(model, principal);
        }
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

}
