package pl.dmichalski.agregator.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.agregator.entity.Blog;
import pl.dmichalski.agregator.entity.Item;

import java.util.List;

/**
 * Author: Daniel
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByBlog(Blog blog, Pageable pageable);

}
