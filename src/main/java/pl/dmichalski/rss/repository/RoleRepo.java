package pl.dmichalski.rss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.rss.entity.UserRoleEntity;

/**
 * Author: Daniel
 */
public interface RoleRepo extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByName(String name);

}
