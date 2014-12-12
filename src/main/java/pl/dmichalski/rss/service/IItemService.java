package pl.dmichalski.rss.service;

import pl.dmichalski.rss.entity.RssFeedEntryEntity;

import java.util.List;

/**
 * Author: Daniel
 */
public interface IItemService {

    public List<RssFeedEntryEntity> findAll();

}
