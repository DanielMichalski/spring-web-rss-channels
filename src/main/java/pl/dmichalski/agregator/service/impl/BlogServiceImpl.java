package pl.dmichalski.agregator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.agregator.entity.Blog;
import pl.dmichalski.agregator.entity.User;
import pl.dmichalski.agregator.repository.BlogRepository;
import pl.dmichalski.agregator.repository.UserRepository;
import pl.dmichalski.agregator.service.BlogService;

/**
 * Author: Daniel
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
    }
}

