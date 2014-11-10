package pl.dmichalski.agregator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.agregator.entity.Blog;
import pl.dmichalski.agregator.entity.Item;
import pl.dmichalski.agregator.entity.User;
import pl.dmichalski.agregator.repository.BlogRepository;
import pl.dmichalski.agregator.repository.ItemRepository;
import pl.dmichalski.agregator.repository.UserRepository;
import pl.dmichalski.agregator.service.UserService;

import java.util.List;

/**
 * Author: Daniel
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findOneWithBlogs(Long id) {
        User user = findOne(id);
        List<Blog> blogs = blogRepository.findByUser(user);
        for (Blog blog : blogs) {
            PageRequest publishedDate = new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate");
            List<Item> items = itemRepository.findByBlog(blog, publishedDate);
            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
