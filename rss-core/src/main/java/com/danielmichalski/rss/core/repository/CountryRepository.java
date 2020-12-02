package com.danielmichalski.rss.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.danielmichalski.rss.core.entity.CountryEntity;

/**
 * Author: Daniel
 */
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
