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
import pl.dmichalski.rss.repository.BlogRepository;
import pl.dmichalski.rss.repository.ItemRepository;
import pl.dmichalski.rss.repository.UserRepository;
import pl.dmichalski.rss.service.IRssFeedService;
import pl.dmichalski.rss.util.log.AutowiredLogger;

import java.util.List;

/**
 * Author: Daniel
 */
@Service
@Transactional
public class RssFeedService implements IRssFeedService {

    @AutowiredLogger
    private Logger logger;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RssService rssService;

    @Override
    public void save(RssFeedEntity rssFeedEntity, String name) {
        UserEntity userEntity = userRepository.findByName(name);
        rssFeedEntity.setUserEntity(userEntity);
        blogRepository.save(rssFeedEntity);
        saveAll(rssFeedEntity);
    }

    @Override
    public void saveAll(RssFeedEntity rssFeedEntity) {
        try {
            List<RssFeedEntryEntity> itemEntities = rssService.getItems(rssFeedEntity.getUrl());
            for (RssFeedEntryEntity rssFeedEntryEntity : itemEntities) {
                RssFeedEntryEntity savedRssFeedEntryEntity = itemRepository.findByRssFeedEntityAndLink(rssFeedEntity, rssFeedEntryEntity.getLink());
                if (savedRssFeedEntryEntity == null) {
                    rssFeedEntryEntity.setRssFeedEntity(rssFeedEntity);
                    itemRepository.save(rssFeedEntryEntity);
                }
            }
        } catch (RSSException e) {
            logger.error("Could not save blog", e);
        }
    }

    @Scheduled(fixedDelay = 3600000)
    public void reloadBlogs() {
        List<RssFeedEntity> blogs = blogRepository.findAll();
        blogs.stream().forEach(this::saveAll);
    }

    @Override
    public RssFeedEntity findOne(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    @PreAuthorize("#blog.userEntity.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") RssFeedEntity rssFeedEntity) {
        blogRepository.delete(rssFeedEntity);
    }
}

