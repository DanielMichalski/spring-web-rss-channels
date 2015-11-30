package pl.dmichalski.rss.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.rss.core.entity.RssFeedEntity;
import pl.dmichalski.rss.core.entity.UserEntity;

import java.util.List;

/**
 * Author: Daniel
 */
public interface BlogRepository extends JpaRepository<RssFeedEntity, Long> {

    List<RssFeedEntity> findByUserEntity(UserEntity userEntity);

}
