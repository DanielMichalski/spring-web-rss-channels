package pl.dmichalski.agregator.service;

import pl.dmichalski.agregator.entity.Blog;

/**
 * Author: Daniel
 */
public interface BlogService {

    void save(Blog blog, String name);

    void saveItems(Blog blog);

    void reloadBlogs();

    Blog findOne(Long id);

    void delete(Blog blog);
}
