package pl.dmichalski.rss.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
import pl.dmichalski.rss.entity.UserEntity;
import pl.dmichalski.rss.service.IMailService;
import pl.dmichalski.rss.service.IUserService;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/web-mvc-config.xml",
        "file:src/main/resources/spring/spring-root.xml",
        "file:src/main/resources/spring/store/spring-data-dev.xml"})
@WebAppConfiguration
public class RegisterControllerTest {

    @InjectMocks
    @Autowired
    private RegisterController registerController;

    @Mock
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
    public void testShowRegisterForm() throws Exception {
        mockMvc.perform(get("/register").accept(MediaType.APPLICATION_XHTML_XML))
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("aUser"))
                .andExpect(status().isOk());

        verifyZeroInteractions(userService);
    }

    @Test
    public void testRegisterUser() throws Exception {
        mockMvc.perform(post("/register").accept(MediaType.APPLICATION_XHTML_XML))
                .andExpect(redirectedUrl("register?registered=true"))
                .andExpect(model().attributeExists("aUser"))
                .andExpect(status().isFound());

        verify(userService, times(1))
                .saveUser(any(UserEntity.class));
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testAvailable() throws Exception {
        String username = "JanKowalski";

        mockMvc.perform(get("/register/is-available")
                .param("username", username))
                .andExpect(status().isOk());

        verify(userService, times(1))
                .findOne(username);
        verifyNoMoreInteractions(userService);
    }
}