package com.firstProject.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.FavoriteList;

import java.util.List;

public interface FavoriteListRepository {
    Long createFavoriteList(FavoriteList favoriteList)throws JsonProcessingException;
    void updateFavoriteList(FavoriteList favoriteList);
    void deleteFavoriteList(Long customerId, Long itemId);
    FavoriteList getFavoriteListById(Long id) throws JsonProcessingException;
    List<FavoriteList> getFavoriteItemsByCustomerId(Long customerId);
}
