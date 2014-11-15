package pl.dmichalski.agregator.service;

import pl.dmichalski.agregator.entity.Blog;

/**
 * Author: Daniel
 */
public interface BlogService {

    void save(Blog blog, String name);

    Blog findOne(Long id);

    void delete(Blog blog);
}
