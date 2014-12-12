package pl.dmichalski.rss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.dmichalski.rss.entity.RssFeedEntryEntity;
import pl.dmichalski.rss.repository.ItemRepo;
import pl.dmichalski.rss.service.IItemService;

import java.util.List;

/**
 * Author: Daniel
 */
@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepo itemRepo;

    public List<RssFeedEntryEntity> findAll() {
        PageRequest pageRequest = new PageRequest(0, 20, Sort.Direction.DESC, "publishedDate");
        return itemRepo.findAll(pageRequest).getContent();
    }

}
