package pl.dmichalski.agregator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.agregator.entity.Blog;
import pl.dmichalski.agregator.entity.Item;
import pl.dmichalski.agregator.entity.User;
import pl.dmichalski.agregator.exception.RSSException;
import pl.dmichalski.agregator.repository.BlogRepository;
import pl.dmichalski.agregator.repository.ItemRepository;
import pl.dmichalski.agregator.repository.UserRepository;
import pl.dmichalski.agregator.service.BlogService;

import java.util.List;

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

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RssService rssService;

    @Override
    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
        saveItems(blog);
    }

    @Override
    public void saveItems(Blog blog) {
        try {
            List<Item> items = rssService.getItems(blog.getUrl());
            for (Item item : items) {
                Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
                if (savedItem == null) {
                    item.setBlog(blog);
                    itemRepository.save(item);
                }
            }
        } catch (RSSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Blog findOne(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);
    }
}

