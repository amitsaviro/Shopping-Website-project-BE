package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.FavoriteList;
import com.firstProject.model.OrderList;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FavoriteListService {
    Long createFavoriteList(FavoriteList favoriteList) throws JsonProcessingException;
    void updateFavoriteList(FavoriteList favoriteList);
    void deleteFavoriteListById(Long id);
    FavoriteList getFavoriteListById(Long id) throws JsonProcessingException;
    List<FavoriteList> getFavoriteItemsByCustomerId(Long customerId) throws JsonProcessingException;
}
