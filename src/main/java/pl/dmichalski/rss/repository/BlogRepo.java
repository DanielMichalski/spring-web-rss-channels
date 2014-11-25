package pl.dmichalski.rss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.rss.entity.BlogEntity;
import pl.dmichalski.rss.entity.UserEntity;

import java.util.List;

/**
 * Author: Daniel
 */
public interface BlogRepo extends JpaRepository<BlogEntity, Long> {

    List<BlogEntity> findByUserEntity(UserEntity userEntity);

}
