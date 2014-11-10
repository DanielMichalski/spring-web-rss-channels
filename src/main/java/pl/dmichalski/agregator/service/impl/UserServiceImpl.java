package pl.dmichalski.agregator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.agregator.entity.User;
import pl.dmichalski.agregator.repository.UserRepository;
import pl.dmichalski.agregator.service.UserService;

import java.util.List;

/**
 * Author: Daniel
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }
}
