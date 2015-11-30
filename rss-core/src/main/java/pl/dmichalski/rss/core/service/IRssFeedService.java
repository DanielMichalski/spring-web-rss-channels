package pl.dmichalski.rss.core.service;

import pl.dmichalski.rss.core.entity.RssFeedEntity;

/**
 * Author: Daniel
 */
public interface IRssFeedService {

    void save(RssFeedEntity rssFeedEntity, String name);

    void saveAll(RssFeedEntity rssFeedEntity);

    void reloadChannels();

    RssFeedEntity findOne(Long id);

    void delete(RssFeedEntity rssFeedEntity);
}
