package pl.dmichalski.rss.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.rss.entity.BlogEntity;
import pl.dmichalski.rss.entity.BlogEntryEntity;
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
    public void save(BlogEntity blogEntity, String name) {
        UserEntity userEntity = userRepo.findByName(name);
        blogEntity.setUserEntity(userEntity);
        blogRepo.save(blogEntity);
        saveAll(blogEntity);
    }

    @Override
    public void saveAll(BlogEntity blogEntity) {
        try {
            List<BlogEntryEntity> itemEntities = rssService.getItems(blogEntity.getUrl());
            for (BlogEntryEntity blogEntryEntity : itemEntities) {
                BlogEntryEntity savedBlogEntryEntity = itemRepo.findByBlogEntityAndLink(blogEntity, blogEntryEntity.getLink());
                if (savedBlogEntryEntity == null) {
                    blogEntryEntity.setBlogEntity(blogEntity);
                    itemRepo.save(blogEntryEntity);
                }
            }
        } catch (RSSException e) {
            logger.error("Could not save blog", e);
        }
    }

    @Scheduled(fixedDelay = 3600000)
    public void reloadBlogs() {
        List<BlogEntity> blogs = blogRepo.findAll();
        blogs.stream().forEach(this::saveAll);
    }

    @Override
    public BlogEntity findOne(Long id) {
        return blogRepo.findOne(id);
    }

    @Override
    @PreAuthorize("#blog.userEntity.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") BlogEntity blogEntity) {
        blogRepo.delete(blogEntity);
    }
}

