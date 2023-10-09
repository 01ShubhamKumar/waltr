package com.waltr.waltr.controller;

import com.waltr.waltr.entity.Item;
import com.waltr.waltr.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
private  ItemService itemService;

//http://localhost:8080/items
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item created = itemService.createItem(item);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    //http://localhost:8080/items
    @GetMapping
    public  ResponseEntity<List<Item>> getAllItems() {
        List<Item> allItems = itemService.getAllItems();
        return new ResponseEntity<>(allItems,HttpStatus.OK);
    }
    //http://localhost:8080/items/id
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item itemById = itemService.getItemById(id);
        return new ResponseEntity<>(itemById,HttpStatus.OK);
    }


    //http://localhost:8080/items/id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
