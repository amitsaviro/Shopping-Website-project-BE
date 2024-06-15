package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Item;
import com.firstProject.model.OrderItem;
import com.firstProject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/update/{itemId}")
    public ResponseEntity<String> updateItem(@PathVariable Long itemId, @RequestBody Item item) {
        try {
            itemService.updateItem(itemId, item);
            return ResponseEntity.ok("Item updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating item: " + e.getMessage());
        }
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
