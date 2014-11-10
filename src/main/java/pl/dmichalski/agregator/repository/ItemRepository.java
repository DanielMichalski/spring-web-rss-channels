package pl.dmichalski.agregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmichalski.agregator.entity.Item;

/**
 * Author: Daniel
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
}
