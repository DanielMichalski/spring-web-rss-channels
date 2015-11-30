package pl.dmichalski.rss.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.rss.core.entity.RssFeedEntity;
import pl.dmichalski.rss.core.entity.RssFeedEntryEntity;
import pl.dmichalski.rss.core.entity.UserEntity;
import pl.dmichalski.rss.core.entity.UserRoleEntity;
import pl.dmichalski.rss.core.repository.BlogRepository;
import pl.dmichalski.rss.core.repository.ItemRepository;
import pl.dmichalski.rss.core.repository.RoleRepository;
import pl.dmichalski.rss.core.repository.UserRepository;
import pl.dmichalski.rss.core.service.IUserService;

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
