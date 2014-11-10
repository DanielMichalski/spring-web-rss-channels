package pl.dmichalski.agregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.agregator.entity.User;

/**
 * Author: Daniel
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}
