package pl.dmichalski.rss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.rss.entity.RssFeedEntity;
import pl.dmichalski.rss.entity.RssFeedEntryEntity;
import pl.dmichalski.rss.entity.UserRoleEntity;
import pl.dmichalski.rss.entity.UserEntity;
import pl.dmichalski.rss.exception.RSSException;
import pl.dmichalski.rss.repository.BlogRepository;
import pl.dmichalski.rss.repository.RoleRepository;
import pl.dmichalski.rss.repository.UserRepository;
import pl.dmichalski.rss.service.IRssFeedService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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
    private RssService rssService;

    @Autowired
    private IRssFeedService blogService;

    @PostConstruct
    public void init() throws RSSException {
        if (roleRepository.findByName("ROLE_ADMIN") != null)  return;

        UserRoleEntity userRole = createUserRole();
        UserRoleEntity adminRole = createAdminRole();
        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        UserEntity admin = createAdmin();
        List<UserRoleEntity> roles = createRoles(userRole, adminRole);
        admin.setRoleEntities(roles);
        userRepository.save(admin);

        createBlogs(admin);
    }

    private UserRoleEntity createUserRole() {
        UserRoleEntity userRoleEntityUser = new UserRoleEntity();
        userRoleEntityUser.setName("ROLE_USER");
        return userRoleEntityUser;
    }

    private UserRoleEntity createAdminRole() {
        UserRoleEntity userRoleEntityAdmin = new UserRoleEntity();
        userRoleEntityAdmin.setName("ROLE_ADMIN");
        return userRoleEntityAdmin;
    }

    private List<UserRoleEntity> createRoles(UserRoleEntity userRole, UserRoleEntity adminRole) {
        List<UserRoleEntity> roleEntities = new ArrayList<>();
        roleEntities.add(adminRole);
        roleEntities.add(userRole);
        return roleEntities;
    }

    private UserEntity createAdmin() {
        UserEntity admin = new UserEntity();
        admin.setEnabled(true);
        admin.setName("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        admin.setPassword(encoder.encode("admin"));
        return admin;
    }

    private void createBlogs(UserEntity user) throws RSSException {
        RssFeedEntity rssFeedEntity1 = saveBlog(user, "World News", "http://feeds.skynews.com/feeds/rss/world.xml");
        saveItems(rssFeedEntity1);
    }

    private RssFeedEntity saveBlog(UserEntity user, String name, String url) {
        RssFeedEntity rssFeedEntity = new RssFeedEntity();
        rssFeedEntity.setName(name);
        rssFeedEntity.setUrl(url);
        rssFeedEntity.setUserEntity(user);
        blogRepository.save(rssFeedEntity);
        return rssFeedEntity;
    }

    private void saveItems(RssFeedEntity rssFeedEntity) throws RSSException {
        List<RssFeedEntryEntity> itemEntities = rssService.getItems(rssFeedEntity.getUrl());
        rssFeedEntity.setItemEntities(itemEntities);
        blogService.saveAll(rssFeedEntity);
    }

}
