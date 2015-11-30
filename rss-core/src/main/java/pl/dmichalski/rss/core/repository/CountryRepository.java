package pl.dmichalski.rss.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.rss.core.entity.CountryEntity;

/**
 * Author: Daniel
 */
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
