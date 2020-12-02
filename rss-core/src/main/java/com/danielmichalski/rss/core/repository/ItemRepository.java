package com.danielmichalski.rss.core.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.danielmichalski.rss.core.entity.RssFeedEntity;
import com.danielmichalski.rss.core.entity.RssFeedEntryEntity;

/**
 * Author: Daniel
 */
public interface ItemRepository extends JpaRepository<RssFeedEntryEntity, Long> {

    List<RssFeedEntryEntity> findByRssFeedEntity(RssFeedEntity rssFeedEntity, Pageable pageable);

    RssFeedEntryEntity findByRssFeedEntityAndLink(RssFeedEntity rssFeedEntity, String link);

}
