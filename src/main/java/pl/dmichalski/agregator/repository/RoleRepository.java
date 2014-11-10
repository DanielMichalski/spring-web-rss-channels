package pl.dmichalski.agregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.agregator.entity.Role;

/**
 * Author: Daniel
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
