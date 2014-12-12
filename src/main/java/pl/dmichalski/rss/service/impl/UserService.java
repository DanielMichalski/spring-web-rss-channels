package pl.dmichalski.rss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.rss.entity.RssFeedEntity;
import pl.dmichalski.rss.entity.RssFeedEntryEntity;
import pl.dmichalski.rss.entity.UserRoleEntity;
import pl.dmichalski.rss.entity.UserEntity;
import pl.dmichalski.rss.repository.BlogRepository;
import pl.dmichalski.rss.repository.ItemRepository;
import pl.dmichalski.rss.repository.RoleRepository;
import pl.dmichalski.rss.repository.UserRepository;
import pl.dmichalski.rss.service.IUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daniel
 */
@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserEntity findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserEntity findOne(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public UserEntity findOneWithAllBlogs(Long id) {
        UserEntity userEntity = findOne(id);
        List<RssFeedEntity> blogEntities = blogRepository.findByUserEntity(userEntity);
        for (RssFeedEntity rssFeedEntity : blogEntities) {
            PageRequest publishedDate = new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate");
            List<RssFeedEntryEntity> itemEntities = itemRepository.findByRssFeedEntity(rssFeedEntity, publishedDate);
            rssFeedEntity.setItemEntities(itemEntities);
        }
        userEntity.setBlogEntities(blogEntities);
        return userEntity;
    }

    @Override
    public UserEntity findOneWithAllBlogs(String name) {
        UserEntity userEntity = userRepository.findByName(name);
        return findOneWithAllBlogs(userEntity.getId());
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userEntity.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));

        List<UserRoleEntity> roleEntities = new ArrayList<>();
        roleEntities.add(roleRepository.findByName("ROLE_USER"));
        userEntity.setRoleEntities(roleEntities);

        userRepository.save(userEntity);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.delete(id);
    }
}
