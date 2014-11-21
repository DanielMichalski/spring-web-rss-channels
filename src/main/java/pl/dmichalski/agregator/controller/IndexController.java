package pl.dmichalski.agregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmichalski.agregator.service.ItemService;

/**
 * Author: Daniel
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "test";
    }

}
