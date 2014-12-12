package pl.dmichalski.rss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmichalski.rss.service.IRssFeedItemService;

/**
 * Author: Daniel
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private IRssFeedItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "index";
    }

}
