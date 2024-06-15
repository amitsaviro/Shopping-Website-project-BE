package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Item;
import com.firstProject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Long createItem(Item item) throws JsonProcessingException {
        return itemRepository.createItem(item);
    }

    @Override
    public ResponseEntity<String> updateItem(Long itemId, Item item) {
        item.setItemId(itemId);
        itemRepository.updateItem(item);
        return ResponseEntity.ok().build();
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteItemById(id);
    }

    @Override
    public Item getItemById(Long id) throws JsonProcessingException {
        return itemRepository.getItemById(id);
    }
    public List<Item> getAllItems() throws JsonProcessingException{
        return itemRepository.getAllItems();
    }
}
