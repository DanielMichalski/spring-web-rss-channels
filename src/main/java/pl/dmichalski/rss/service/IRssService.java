package pl.dmichalski.rss.service;

import pl.dmichalski.rss.entity.BlogEntryEntity;
import pl.dmichalski.rss.exception.RSSException;

import java.io.File;
import java.util.List;

/**
 * Author: Daniel
 */
public interface IRssService {

    List<BlogEntryEntity> getItems(File file) throws RSSException;

    List<BlogEntryEntity> getItems(String url) throws RSSException;

}
