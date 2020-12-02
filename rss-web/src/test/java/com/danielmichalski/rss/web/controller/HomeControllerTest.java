package com.danielmichalski.rss.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.danielmichalski.rss.core.service.IRssFeedItemService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/web-mvc-config.xml",
        "file:src/main/resources/spring/spring-root.xml",
        "file:src/main/resources/spring/store/spring-data-dev.xml"})
@WebAppConfiguration
public class HomeControllerTest {

    @InjectMocks
    @Autowired
    private HomeController homeController;

    @Mock
    private IRssFeedItemService itemService;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/").accept(MediaType.APPLICATION_XHTML_XML))
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("items"))
                .andExpect(status().isOk());

        verify(itemService, times(1))
                .find10NewestEntries();
        verifyNoMoreInteractions(itemService);
    }

}
