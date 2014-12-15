package pl.dmichalski.rss.service;

import pl.dmichalski.rss.entity.RssFeedEntryEntity;

import java.util.List;

/**
 * Author: Daniel
 */
public interface IRssFeedItemService {

    public List<RssFeedEntryEntity> findAll();

    public List<RssFeedEntryEntity> find10NewestEntries();

}
