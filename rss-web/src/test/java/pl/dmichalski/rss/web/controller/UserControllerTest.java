package pl.dmichalski.rss.web.controller;

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
import pl.dmichalski.rss.core.entity.RssFeedEntity;
import pl.dmichalski.rss.core.service.IRssFeedService;
import pl.dmichalski.rss.core.service.IUserService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/web-mvc-config.xml",
        "file:src/main/resources/spring/spring-root.xml",
        "file:src/main/resources/spring/store/spring-data-dev.xml"})
@WebAppConfiguration
public class UserControllerTest {

    @InjectMocks
    @Autowired
    private UserController userController;

    @Mock
    @Autowired
    private IUserService userService;

    @Mock
    @Autowired
    private IRssFeedService blogService;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testAccount() throws Exception {
//        mockMvc.perform(get("/account").accept(MediaType.APPLICATION_XHTML_XML))
//                .andExpect(view().name("account"))
//                .andExpect(model().attributeExists("blog"))
//                .andExpect(model().attributeExists("user"))
//                .andExpect(status().isOk());
//
//        verify(userService, times(1))
//                .findOneWithAllBlogs(any(String.class));
//        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testDoAddBlog() throws Exception {
//        mockMvc.perform(post("/account").accept(MediaType.APPLICATION_XHTML_XML))
//                .andExpect(view().name("show-users"))
//                .andExpect(redirectedUrl("/account"))
//                .andExpect(status().isOk());
//
//        verify(blogService, times(1))
//                .save(any());
//        verifyNoMoreInteractions(blogService);
    }

    @Test
    public void testRemoveBlog() throws Exception {
        Long id = 5L;
        RssFeedEntity rssFeedEntity = new RssFeedEntity();

        when(blogService.findOne(id)).thenReturn(rssFeedEntity);

        mockMvc.perform(get("/blog/remove/" + id).accept(MediaType.APPLICATION_XHTML_XML))
                .andExpect(redirectedUrl("/account"))
                .andExpect(status().isFound());

        verify(blogService, times(1))
                .findOne(id);
        verifyNoMoreInteractions(userService);
    }
}