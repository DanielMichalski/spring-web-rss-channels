package com.danielmichalski.rss.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.danielmichalski.rss.core.form.ContactForm;
import com.danielmichalski.rss.core.service.IMailService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/web-mvc-config.xml",
        "file:src/main/resources/spring/spring-root.xml",
        "file:src/main/resources/spring/store/spring-data-dev.xml"})
@WebAppConfiguration
public class ContactControllerTest {

    @InjectMocks
    @Autowired
    private ContactController ContactController;

    @Mock
    private IMailService mailService;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Value("${mail.sender.receiver}")
    private String mailTo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testShowContactForm() throws Exception {
        mockMvc.perform(get("/contact").accept(MediaType.APPLICATION_XHTML_XML))
                .andExpect(view().name("contact"))
                .andExpect(model().attributeExists("contactForm"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSendEmail() throws Exception {
        String from = "test@mail.com";
        String message = "Mail message";
        String name = "Name";

        ContactForm contactForm = new ContactForm();
        contactForm.setMail(from);
        contactForm.setMessage(message);
        contactForm.setName(name);

        Mockito.when(mailService.sendEMail(from, mailTo, "Message from " + name, message)).thenReturn(true);

        mockMvc.perform(post("/contact").accept(MediaType.APPLICATION_XHTML_XML)
                .sessionAttr("contactForm", contactForm))
                .andExpect(redirectedUrl("contact?sent=false"))
                .andExpect(model().attributeExists("contactForm"));
    }
}
