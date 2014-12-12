package pl.dmichalski.rss.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.rss.entity.RssFeedEntity;
import pl.dmichalski.rss.entity.RssFeedEntryEntity;
import pl.dmichalski.rss.entity.UserEntity;
import pl.dmichalski.rss.exception.RSSException;
import pl.dmichalski.rss.repository.BlogRepo;
import pl.dmichalski.rss.repository.ItemRepo;
import pl.dmichalski.rss.repository.UserRepo;
import pl.dmichalski.rss.service.IBlogService;
import pl.dmichalski.rss.util.log.AutowiredLogger;

import java.util.List;

/**
 * Author: Daniel
 */
@Service
@Transactional
public class BlogService implements IBlogService {

    @AutowiredLogger
    private Logger logger;

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private RssService rssService;

    @Override
    public void save(RssFeedEntity rssFeedEntity, String name) {
        UserEntity userEntity = userRepo.findByName(name);
        rssFeedEntity.setUserEntity(userEntity);
        blogRepo.save(rssFeedEntity);
        saveAll(rssFeedEntity);
    }

    @Override
    public void saveAll(RssFeedEntity rssFeedEntity) {
        try {
            List<RssFeedEntryEntity> itemEntities = rssService.getItems(rssFeedEntity.getUrl());
            for (RssFeedEntryEntity rssFeedEntryEntity : itemEntities) {
                RssFeedEntryEntity savedRssFeedEntryEntity = itemRepo.findByRssFeedEntityAndLink(rssFeedEntity, rssFeedEntryEntity.getLink());
                if (savedRssFeedEntryEntity == null) {
                    rssFeedEntryEntity.setRssFeedEntity(rssFeedEntity);
                    itemRepo.save(rssFeedEntryEntity);
                }
            }
        } catch (RSSException e) {
            logger.error("Could not save blog", e);
        }
    }

    @Scheduled(fixedDelay = 3600000)
    public void reloadBlogs() {
        List<RssFeedEntity> blogs = blogRepo.findAll();
        blogs.stream().forEach(this::saveAll);
    }

    @Override
    public RssFeedEntity findOne(Long id) {
        return blogRepo.findOne(id);
    }

    @Override
    @PreAuthorize("#blog.userEntity.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") RssFeedEntity rssFeedEntity) {
        blogRepo.delete(rssFeedEntity);
    }
}

