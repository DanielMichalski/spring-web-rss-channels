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
import com.danielmichalski.rss.core.service.IUserService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/web-mvc-config.xml",
        "file:src/main/resources/spring/spring-root.xml",
        "file:src/main/resources/spring/store/spring-data-dev.xml"})
@WebAppConfiguration
public class AdminControllerTest {

    @InjectMocks
    @Autowired
    private AdminController adminController;

    @Mock
    @Autowired
    private IUserService userService;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testShowUsers() throws Exception {
        mockMvc.perform(get("/admin/users").accept(MediaType.APPLICATION_XHTML_XML))
                .andExpect(view().name("show-users"))
                .andExpect(model().attributeExists("usersList"))
                .andExpect(status().isOk());

        verify(userService, times(1))
                .findAll();
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testUserDetail() throws Exception {
        long id = 1;
        mockMvc.perform(get("/admin/users/" + id).accept(MediaType.APPLICATION_XHTML_XML))
                .andExpect(view().name("user-detail"))
                .andExpect(model().errorCount(0))
                .andExpect(status().isOk());

        verify(userService, times(1))
                .findOneWithAllBlogs(id);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testRemoveUserById() throws Exception {
        long id = 1;
        mockMvc.perform(get("/admin/users/remove-user/" + id).accept(MediaType.APPLICATION_XHTML_XML))
                .andExpect(redirectedUrl("/admin/users"))
                .andExpect(status().isFound());

        verify(userService, times(1))
                .removeUser(id);
        verifyNoMoreInteractions(userService);
    }
}
