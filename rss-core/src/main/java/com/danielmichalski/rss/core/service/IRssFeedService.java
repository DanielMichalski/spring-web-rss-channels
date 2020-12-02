package com.danielmichalski.rss.core.service;

import com.danielmichalski.rss.core.entity.RssFeedEntity;

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
