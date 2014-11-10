package pl.dmichalski.agregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.agregator.entity.Blog;

/**
 * Author: Daniel
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
