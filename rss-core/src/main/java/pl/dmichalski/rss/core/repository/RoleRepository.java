package pl.dmichalski.rss.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.rss.core.entity.UserRoleEntity;

/**
 * Author: Daniel
 */
public interface RoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByName(String name);

}
