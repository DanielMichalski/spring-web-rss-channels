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

        RssFeedEntity rssFeedEntity1 = saveBlog("TVN Najnowsze", "http://www.tvn24.pl/najnowsze.xml");
        RssFeedEntity rssFeedEntity2 = saveBlog("TVN Najważniejsze", "http://www.tvn24.pl/najwazniejsze.xml");
        RssFeedEntity rssFeedEntity3 = saveBlog("TVN Świat", "http://www.tvn24.pl/wiadomosci-ze-swiata,2.xml");
        RssFeedEntity rssFeedEntity4 = saveBlog("TVN Sport", "http://sport.tvn24.pl/sport,81,m.xml");

        saveItems(rssFeedEntity1);
        saveItems(rssFeedEntity2);
        saveItems(rssFeedEntity3);
        saveItems(rssFeedEntity4);

    }

    private RssFeedEntity saveBlog(String name, String url) {
        RssFeedEntity rssFeedEntity = new RssFeedEntity();
        rssFeedEntity.setName(name);
        rssFeedEntity.setUrl(url);
        rssFeedEntity.setUserEntity(userEntityAdmin);
        blogRepo.save(rssFeedEntity);
        return rssFeedEntity;
    }

    private void saveItems(RssFeedEntity rssFeedEntity) throws RSSException {
        List<RssFeedEntryEntity> itemEntities = rssService.getItems(rssFeedEntity.getUrl());
        rssFeedEntity.setItemEntities(itemEntities);
        blogService.saveAll(rssFeedEntity);
    }

}
