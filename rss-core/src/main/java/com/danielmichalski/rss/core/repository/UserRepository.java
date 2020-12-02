package com.danielmichalski.rss.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.danielmichalski.rss.core.entity.UserEntity;

/**
 * Author: Daniel
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByName(String name);

}
