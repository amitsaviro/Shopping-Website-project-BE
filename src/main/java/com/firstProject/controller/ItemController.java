package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Item;
import com.firstProject.model.OrderItem;
import com.firstProject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http:localhost:3000")
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/create")
    public void createItem(@RequestBody Item item) throws JsonProcessingException {
        itemService.createItem(item);
    }

    @PutMapping("/update")
    public void updateItem(@RequestBody Item item){
        itemService.updateItem(item);
    }

    @DeleteMapping("/delete/{itemId}")
    public void deleteItemById(@PathVariable Long itemId){
        itemService.deleteItemById(itemId);
    }

    @GetMapping("/get/{itemId}")
    public Item getItemById(@PathVariable Long itemId) throws JsonProcessingException {
        return itemService.getItemById(itemId);
    }
    @GetMapping("/getAllItems")
    public List<Item> getAllItems() throws JsonProcessingException {
        return itemService.getAllItems();
    }
}
