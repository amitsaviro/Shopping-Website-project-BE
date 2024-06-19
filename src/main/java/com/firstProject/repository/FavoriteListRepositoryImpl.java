package com.firstProject.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstProject.model.FavoriteList;
import com.firstProject.repository.mapper.FavoriteListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FavoriteListRepositoryImpl implements FavoriteListRepository{
    private static final String FAVORITE_LIST_TABLE_NAME = "favorite_list";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FavoriteListMapper favoriteListMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long createFavoriteList(FavoriteList favoriteList)throws JsonProcessingException {
        String sql = "INSERT INTO " + FAVORITE_LIST_TABLE_NAME + " (customer_id, item_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, favoriteList.getCustomerId(), favoriteList.getItemId());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateFavoriteList(FavoriteList favoriteList) {
        String sql = "UPDATE " + FAVORITE_LIST_TABLE_NAME + " SET customer_id=?, item_id=? WHERE favorite_list_id=?";
        jdbcTemplate.update(sql, favoriteList.getCustomerId(), favoriteList.getItemId(), favoriteList.getFavoriteListId());
    }

    @Override
    public void deleteFavoriteList(Long customerId, Long itemId) {
        String sql = "DELETE FROM " + FAVORITE_LIST_TABLE_NAME + " WHERE customer_id=? AND item_id=?";
        jdbcTemplate.update(sql, customerId, itemId);
    }


    @Override
    public FavoriteList getFavoriteListById(Long id) throws JsonProcessingException {
        String sql = "SELECT * FROM " + FAVORITE_LIST_TABLE_NAME + " WHERE favorite_list_id=?";
        FavoriteList favoriteList = jdbcTemplate.queryForObject(sql, favoriteListMapper, id);
        return favoriteList;
    }
    @Override
    public List<FavoriteList> getFavoriteItemsByCustomerId(Long customerId) {
        String sql = "SELECT * FROM " + FAVORITE_LIST_TABLE_NAME + " WHERE customer_id=?";
            return jdbcTemplate.query(sql, favoriteListMapper, customerId);
    }
}


