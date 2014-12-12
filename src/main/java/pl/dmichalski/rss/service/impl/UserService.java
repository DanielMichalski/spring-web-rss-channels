package pl.dmichalski.rss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmichalski.rss.entity.BlogEntity;
import pl.dmichalski.rss.entity.BlogEntryEntity;
import pl.dmichalski.rss.entity.UserRoleEntity;
import pl.dmichalski.rss.entity.UserEntity;
import pl.dmichalski.rss.repository.BlogRepo;
import pl.dmichalski.rss.repository.ItemRepo;
import pl.dmichalski.rss.repository.RoleRepo;
import pl.dmichalski.rss.repository.UserRepo;
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
    private UserRepo userRepo;

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<UserEntity> findAll(){
        return userRepo.findAll();
    }

    @Override
    public UserEntity findOne(Long id) {
        return userRepo.findOne(id);
    }

    @Override
    public UserEntity findOne(String username) {
        return userRepo.findByName(username);
    }

    @Override
    public UserEntity findOneWithAllBlogs(Long id) {
        UserEntity userEntity = findOne(id);
        List<BlogEntity> blogEntities = blogRepo.findByUserEntity(userEntity);
        for (BlogEntity blogEntity : blogEntities) {
            PageRequest publishedDate = new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate");
            List<BlogEntryEntity> itemEntities = itemRepo.findByBlogEntity(blogEntity, publishedDate);
            blogEntity.setItemEntities(itemEntities);
        }
        userEntity.setBlogEntities(blogEntities);
        return userEntity;
    }

    @Override
    public UserEntity findOneWithAllBlogs(String name) {
        UserEntity userEntity = userRepo.findByName(name);
        return findOneWithAllBlogs(userEntity.getId());
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userEntity.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));

        List<UserRoleEntity> roleEntities = new ArrayList<>();
        roleEntities.add(roleRepo.findByName("ROLE_USER"));
        userEntity.setRoleEntities(roleEntities);

        userRepo.save(userEntity);
    }

    @Override
    public void removeUser(Long id) {
        userRepo.delete(id);
    }
}
