package com.danielmichalski.rss.core.service;

import java.util.List;

import com.danielmichalski.rss.core.entity.UserEntity;

/**
 * Author: Daniel
 */
public interface IUserService {

    List<UserEntity> findAll();

    UserEntity findOne(Long id);

    UserEntity findOne(String username);

    UserEntity findOneWithAllBlogs(Long id);

    UserEntity findOneWithAllBlogs(String name);

    void saveUser(UserEntity userEntity);

    void removeUser(Long id);

}
