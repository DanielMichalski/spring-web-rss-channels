package pl.dmichalski.rss.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.dmichalski.rss.core.entity.RssFeedEntryEntity;
import pl.dmichalski.rss.core.repository.ItemRepository;
import pl.dmichalski.rss.core.service.IRssFeedItemService;

import java.util.List;

/**
 * Author: Daniel
 */
@Service
public class RssFeedItemService implements IRssFeedItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<RssFeedEntryEntity> findAll() {
        return itemRepository.findAll();
    }

    public List<RssFeedEntryEntity> find10NewestEntries() {
        PageRequest pageRequest = new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate");
        return itemRepository.findAll(pageRequest).getContent();
    }

}
