package pl.dmichalski.rss.service;

import pl.dmichalski.rss.entity.RssFeedEntity;

/**
 * Author: Daniel
 */
public interface IRssFeedService {

    void save(RssFeedEntity rssFeedEntity, String name);

    void saveAll(RssFeedEntity rssFeedEntity);

    void reloadBlogs();

    RssFeedEntity findOne(Long id);

    void delete(RssFeedEntity rssFeedEntity);
}
