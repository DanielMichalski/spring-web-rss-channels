package com.danielmichalski.rss.core.service;

import java.io.File;
import java.util.List;

import com.danielmichalski.rss.core.exception.RSSException;
import com.danielmichalski.rss.core.entity.RssFeedEntryEntity;

/**
 * Author: Daniel
 */
public interface IRssService {

    List<RssFeedEntryEntity> getItems(File file) throws RSSException;

    List<RssFeedEntryEntity> getItems(String url) throws RSSException;

}
