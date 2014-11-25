package pl.dmichalski.rss.service;

import pl.dmichalski.rss.entity.BlogEntryEntity;

import java.util.List;

/**
 * Author: Daniel
 */
public interface IItemService {

    public List<BlogEntryEntity> findAll();

}
