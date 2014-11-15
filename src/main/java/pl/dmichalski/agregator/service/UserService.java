package pl.dmichalski.agregator.service;

import pl.dmichalski.agregator.entity.User;

import java.util.List;

/**
 * Author: Daniel
 */
public interface UserService {

    List<User> findAll();

    User findOne(Long id);

    User findOne(String username);

    User findOneWithBlogs(Long id);

    User findOneWithBlogs(String name);

    void save(User user);

    void remove(Long id);

}
