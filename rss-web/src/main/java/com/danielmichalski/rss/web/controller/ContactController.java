package com.danielmichalski.rss.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.danielmichalski.rss.core.form.ContactForm;
import com.danielmichalski.rss.core.service.IMailService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    @Value("${mail.sender.receiver}")
    private String mailTo;

    private IMailService mailService;

    @Autowired
    public ContactController(IMailService mailService) {
        this.mailService = mailService;
    }

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

        String name = contactForm.getName();
        String from = contactForm.getMail();
        String message = contactForm.getMessage();

        boolean emailSent = mailService.sendEMail(from, mailTo, "Message from " + name, message);
        return "redirect:contact?sent=" + emailSent;
    }

}

