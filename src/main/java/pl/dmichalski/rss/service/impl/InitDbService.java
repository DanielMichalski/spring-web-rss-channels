package pl.dmichalski.rss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.rss.entity.BlogEntity;
import pl.dmichalski.rss.entity.BlogEntryEntity;
import pl.dmichalski.rss.entity.UserRoleEntity;
import pl.dmichalski.rss.entity.UserEntity;
import pl.dmichalski.rss.exception.RSSException;
import pl.dmichalski.rss.repository.BlogRepo;
import pl.dmichalski.rss.repository.RoleRepo;
import pl.dmichalski.rss.repository.UserRepo;
import pl.dmichalski.rss.service.IBlogService;

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
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private RssService rssService;

    @Autowired
    private IBlogService blogService;

    private UserEntity userEntityAdmin;

    @PostConstruct
    public void init() throws RSSException {
        if (roleRepo.findByName("ROLE_ADMIN") != null)  return;

        UserRoleEntity userRoleEntityUser = new UserRoleEntity();
        userRoleEntityUser.setName("ROLE_USER");
        roleRepo.save(userRoleEntityUser);

        UserRoleEntity userRoleEntityAdmin = new UserRoleEntity();
        userRoleEntityAdmin.setName("ROLE_ADMIN");
        roleRepo.save(userRoleEntityAdmin);

        userEntityAdmin = new UserEntity();
        userEntityAdmin.setEnabled(true);
        userEntityAdmin.setName("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userEntityAdmin.setPassword(encoder.encode("admin"));
        List<UserRoleEntity> roleEntities = new ArrayList<>();
        roleEntities.add(userRoleEntityAdmin);
        roleEntities.add(userRoleEntityUser);
        userEntityAdmin.setRoleEntities(roleEntities);
        userRepo.save(userEntityAdmin);

        BlogEntity blogEntity1 = saveBlog("TVN Najnowsze", "http://www.tvn24.pl/najnowsze.xml");
        BlogEntity blogEntity2 = saveBlog("TVN Najważniejsze", "http://www.tvn24.pl/najwazniejsze.xml");
        BlogEntity blogEntity3 = saveBlog("TVN Świat", "http://www.tvn24.pl/wiadomosci-ze-swiata,2.xml");
        BlogEntity blogEntity4 = saveBlog("TVN Sport", "http://sport.tvn24.pl/sport,81,m.xml");

        saveItems(blogEntity1);
        saveItems(blogEntity2);
        saveItems(blogEntity3);
        saveItems(blogEntity4);

    }

    private BlogEntity saveBlog(String name, String url) {
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setName(name);
        blogEntity.setUrl(url);
        blogEntity.setUserEntity(userEntityAdmin);
        blogRepo.save(blogEntity);
        return blogEntity;
    }

    private void saveItems(BlogEntity blogEntity) throws RSSException {
        List<BlogEntryEntity> itemEntities = rssService.getItems(blogEntity.getUrl());
        blogEntity.setItemEntities(itemEntities);
        blogService.saveAll(blogEntity);
    }

}
