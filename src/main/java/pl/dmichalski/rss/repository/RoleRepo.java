package pl.dmichalski.rss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.rss.entity.RoleEntity;

/**
 * Author: Daniel
 */
public interface RoleRepo extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);

}
