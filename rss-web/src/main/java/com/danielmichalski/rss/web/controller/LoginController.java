package com.danielmichalski.rss.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Daniel
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping
    public String login() {
        return "login";
    }

}
