package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Customer;
import com.firstProject.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ItemService {
    Long createItem(Item item) throws JsonProcessingException;
    ResponseEntity<String> updateItem(Long itemId,Item item);

    void deleteItemById(Long id);
    Item getItemById(Long id) throws JsonProcessingException;
    List<Item> getAllItems() throws JsonProcessingException;

    }
