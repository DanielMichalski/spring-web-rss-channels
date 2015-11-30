package pl.dmichalski.rss.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dmichalski.rss.core.entity.UserEntity;
import pl.dmichalski.rss.core.service.IUserService;

import javax.validation.Valid;

/**
 * Author: Daniel
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private IUserService userService;

    @Autowired
    public RegisterController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("aUser", new UserEntity());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(
            @Valid @ModelAttribute("aUser") UserEntity userEntity,
            BindingResult results) {
        if (results.hasErrors()) {
            return "register";
        }
        userService.saveUser(userEntity);
        return "redirect:register?registered=true";
    }

    @RequestMapping("is-available")
    @ResponseBody
    public String available(@RequestParam String username) {
        Boolean available = userService.findOne(username) == null;
        return available.toString();
    }
}