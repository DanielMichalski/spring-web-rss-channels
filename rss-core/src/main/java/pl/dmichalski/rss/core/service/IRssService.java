package pl.dmichalski.rss.core.service;

import java.io.File;
import java.util.List;

import pl.dmichalski.rss.core.entity.RssFeedEntryEntity;
import pl.dmichalski.rss.core.exception.RSSException;

/**
 * Author: Daniel
 */
public interface IRssService {

    List<RssFeedEntryEntity> getItems(File file) throws RSSException;

    List<RssFeedEntryEntity> getItems(String url) throws RSSException;

}
