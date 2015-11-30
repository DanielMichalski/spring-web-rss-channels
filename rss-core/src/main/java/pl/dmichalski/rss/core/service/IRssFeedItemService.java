package pl.dmichalski.rss.core.service;

import pl.dmichalski.rss.core.entity.RssFeedEntryEntity;

import java.util.List;

/**
 * Author: Daniel
 */
public interface IRssFeedItemService {

    public List<RssFeedEntryEntity> findAll();

    public List<RssFeedEntryEntity> find10NewestEntries();

}
