package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.FavoriteList;
import com.firstProject.model.OrderList;
import com.firstProject.service.FavoriteListService;
import com.firstProject.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http:localhost:3000")

@RestController
@RequestMapping("/favoriteList")
public class FavoriteListController {
    @Autowired
    private FavoriteListService favoriteListService;

    @PostMapping("/create")
    public void createFavoriteList(@RequestBody FavoriteList favoriteList) throws JsonProcessingException {
        favoriteListService.createFavoriteList(favoriteList);
    }

    @PutMapping("/update")
    public void updateFavoriteList(@RequestBody FavoriteList favoriteList){
        favoriteListService.updateFavoriteList(favoriteList);
    }

    @DeleteMapping("/delete/{favoriteListId}")
    public void deleteFavoriteListById(@PathVariable Long favoriteListId){
        favoriteListService.deleteFavoriteListById(favoriteListId);
    }

    @GetMapping("get/{favoriteListId}")
    public FavoriteList getFavoriteListById(@PathVariable Long favoriteListId) throws JsonProcessingException {
        return favoriteListService.getFavoriteListById(favoriteListId);
    }

    @GetMapping("/getAllFavoriteListByCustomerId/{customerId}")
    public List<FavoriteList> getFavoriteItemsByCustomerId(@PathVariable Long customerId) throws JsonProcessingException
    {
        return favoriteListService.getFavoriteItemsByCustomerId(customerId);
    }
}
