package pl.dmichalski.rss.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.rss.entity.BlogEntity;
import pl.dmichalski.rss.entity.BlogEntryEntity;

import java.util.List;

/**
 * Author: Daniel
 */
public interface ItemRepo extends JpaRepository<BlogEntryEntity, Long> {

    List<BlogEntryEntity> findByBlogEntity(BlogEntity blogEntity, Pageable pageable);

    BlogEntryEntity findByBlogEntityAndLink(BlogEntity blogEntity, String link);

}
