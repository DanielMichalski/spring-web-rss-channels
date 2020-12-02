package com.danielmichalski.rss.core.service;

import java.util.List;

import com.danielmichalski.rss.core.entity.RssFeedEntryEntity;

/**
 * Author: Daniel
 */
public interface IRssFeedItemService {

    public List<RssFeedEntryEntity> findAll();

    public List<RssFeedEntryEntity> find10NewestEntries();

}
