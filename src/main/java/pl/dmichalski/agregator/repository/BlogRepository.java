package pl.dmichalski.agregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.agregator.entity.Blog;
import pl.dmichalski.agregator.entity.User;

import java.util.List;

/**
 * Author: Daniel
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByUser(User user);

}
