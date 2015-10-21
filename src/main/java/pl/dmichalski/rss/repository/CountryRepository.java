package pl.dmichalski.rss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.rss.entity.CountryEntity;

/**
 * Author: Daniel
 */
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
