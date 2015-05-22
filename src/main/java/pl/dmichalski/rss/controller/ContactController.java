package pl.dmichalski.rss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmichalski.rss.form.ContactForm;

import javax.validation.Valid;

/**
 * Author: dmichalski
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    @RequestMapping(method = RequestMethod.GET)
    public String showContactForm(Model model) {
        ContactForm attributeValue = new ContactForm();
        model.addAttribute("contactForm", attributeValue);
        return "contact";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String sendEmail(@Valid @ModelAttribute("contactForm") ContactForm contactForm, BindingResult results) {
        if (results.hasErrors()) {
            return "contact";
        }
        //TODO sending email
        return "redirect:contact?sent=true";
    }

}

