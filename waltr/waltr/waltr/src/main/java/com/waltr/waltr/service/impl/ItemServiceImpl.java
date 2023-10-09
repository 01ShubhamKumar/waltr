package com.waltr.waltr.service.impl;

import com.waltr.waltr.entity.Item;
import com.waltr.waltr.exception.ItemNotFoundException;
import com.waltr.waltr.repository.ItemRepository;
import com.waltr.waltr.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @Override
    public Item createItem(Item item) {
        // You can add validation or additional logic here before saving
        return itemRepository.save(item);
    }
    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return item.get();
        } else {
            throw new ItemNotFoundException("Item not found with ID: " + id);
        }
    }



    @Override
    public void deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new ItemNotFoundException("Item not found with ID: " + id);
        }
    }
}
