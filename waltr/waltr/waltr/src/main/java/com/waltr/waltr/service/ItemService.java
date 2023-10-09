package com.waltr.waltr.service;

import com.waltr.waltr.entity.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);
    List<Item> getAllItems();

    Item getItemById(Long id);



    void deleteItem(Long id);
}
