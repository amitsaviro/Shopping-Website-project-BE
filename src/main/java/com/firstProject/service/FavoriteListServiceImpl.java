package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.FavoriteList;
import com.firstProject.repository.FavoriteListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteListServiceImpl implements FavoriteListService{
    @Autowired
    private FavoriteListRepository favoriteListRepository;

    @Override
    public Long createFavoriteList(FavoriteList favoriteList) throws JsonProcessingException {
        return favoriteListRepository.createFavoriteList(favoriteList);
    }

    @Override
    public void updateFavoriteList(FavoriteList favoriteList) {
        favoriteListRepository.updateFavoriteList(favoriteList);
    }

    @Override
    public void deleteFavoriteListById(Long id) {
        favoriteListRepository.deleteFavoriteListById(id);
    }

    @Override
    public FavoriteList getFavoriteListById(Long id) throws JsonProcessingException {
        return favoriteListRepository.getFavoriteListById(id);
    }
    @Override
    public List<FavoriteList> getFavoriteItemsByCustomerId(Long customerId) throws JsonProcessingException{
        return favoriteListRepository.getFavoriteItemsByCustomerId(customerId);
    }
}


