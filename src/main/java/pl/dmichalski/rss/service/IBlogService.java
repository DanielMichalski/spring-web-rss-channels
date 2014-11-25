package pl.dmichalski.rss.service;

import pl.dmichalski.rss.entity.BlogEntity;

/**
 * Author: Daniel
 */
public interface IBlogService {

    void save(BlogEntity blogEntity, String name);

    void saveAll(BlogEntity blogEntity);

    void reloadBlogs();

    BlogEntity findOne(Long id);

    void delete(BlogEntity blogEntity);
}
