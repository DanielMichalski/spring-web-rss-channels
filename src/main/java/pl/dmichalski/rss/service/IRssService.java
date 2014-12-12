package pl.dmichalski.rss.service;

import pl.dmichalski.rss.entity.RssFeedEntryEntity;
import pl.dmichalski.rss.exception.RSSException;

import java.io.File;
import java.util.List;

/**
 * Author: Daniel
 */
public interface IRssService {

    List<RssFeedEntryEntity> getItems(File file) throws RSSException;

    List<RssFeedEntryEntity> getItems(String url) throws RSSException;

}
