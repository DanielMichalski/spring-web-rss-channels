package pl.dmichalski.rss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmichalski.rss.entity.BlogEntity;
import pl.dmichalski.rss.service.IBlogService;
import pl.dmichalski.rss.service.IUserService;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Author: Daniel
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IBlogService blogService;

    @RequestMapping("/account")
    public String account(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("blog", new BlogEntity());
        model.addAttribute("user", userService.findOneWithAllBlogs(userName));
        return "account";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddBlog(@Valid @ModelAttribute("blog") BlogEntity blogEntity, Model model,
                            Principal principal, BindingResult result) {
        if (result.hasErrors()) {
            return account(model, principal);
        }
        String name = principal.getName();
        blogService.save(blogEntity, name);
        return "redirect:/account";
    }

    @RequestMapping(value = "/blog/remove/{id}")
    public String removeBlog(@PathVariable Long id) {
        BlogEntity blogEntity = blogService.findOne(id);
        blogService.delete(blogEntity);
        return "redirect:/account";
    }

}
