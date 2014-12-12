package pl.dmichalski.rss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.rss.entity.RssFeedEntity;
import pl.dmichalski.rss.entity.UserEntity;

import java.util.List;

/**
 * Author: Daniel
 */
public interface BlogRepo extends JpaRepository<RssFeedEntity, Long> {

    List<RssFeedEntity> findByUserEntity(UserEntity userEntity);

}
