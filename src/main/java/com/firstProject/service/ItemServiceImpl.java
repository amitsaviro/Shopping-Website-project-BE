package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Item;
import com.firstProject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void updateItem(Item item) {
        itemRepository.updateItem(item);
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
