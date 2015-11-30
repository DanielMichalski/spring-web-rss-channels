package pl.dmichalski.rss.core.service;

import pl.dmichalski.rss.core.entity.RssFeedEntryEntity;
import pl.dmichalski.rss.core.exception.RSSException;

import java.io.File;
import java.util.List;

/**
 * Author: Daniel
 */
public interface IRssService {

    List<RssFeedEntryEntity> getItems(File file) throws RSSException;

    List<RssFeedEntryEntity> getItems(String url) throws RSSException;

}
