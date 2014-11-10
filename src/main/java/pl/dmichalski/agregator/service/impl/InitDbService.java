package pl.dmichalski.agregator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.agregator.entity.Blog;
import pl.dmichalski.agregator.entity.Item;
import pl.dmichalski.agregator.entity.Role;
import pl.dmichalski.agregator.entity.User;
import pl.dmichalski.agregator.repository.BlogRepository;
import pl.dmichalski.agregator.repository.ItemRepository;
import pl.dmichalski.agregator.repository.RoleRepository;
import pl.dmichalski.agregator.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: Daniel
 */
@Service
@Transactional
public class InitDbService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        User userAdmin = new User();
        userAdmin.setName("admin");
        userAdmin.setPassword("admin");
        List<Role> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);

        Blog blog = new Blog();
        blog.setName("Blog name");
        blog.setUrl("Excample url");
        blog.setUser(userAdmin);
        blogRepository.save(blog);

        Item item1 = new Item();
        item1.setBlog(blog);
        item1.setTitle("first");
        item1.setLink("Some link");
        item1.setPublishedDate(new Date());
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setBlog(blog);
        item2.setTitle("second");
        item2.setLink("Some link");
        item2.setPublishedDate(new Date());
        itemRepository.save(item2);
    }

}
