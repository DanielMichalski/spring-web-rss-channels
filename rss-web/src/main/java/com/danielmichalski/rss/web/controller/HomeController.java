package com.danielmichalski.rss.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.danielmichalski.rss.core.service.IRssFeedItemService;

/**
 * Author: Daniel
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private IRssFeedItemService itemService;

    @Autowired
    public HomeController(IRssFeedItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", itemService.find10NewestEntries());
        return "index";
    }

}
