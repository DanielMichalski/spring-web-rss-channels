package pl.dmichalski.agregator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.dmichalski.agregator.entity.Item;
import pl.dmichalski.agregator.repository.ItemRepository;
import pl.dmichalski.agregator.service.ItemService;

import java.util.List;

/**
 * Author: Daniel
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems() {
        PageRequest pageRequest = new PageRequest(0, 20, Sort.Direction.DESC, "publishedDate");
        return itemRepository.findAll(pageRequest).getContent();
    }

}
