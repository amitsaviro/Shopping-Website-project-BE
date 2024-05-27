package com.firstProject.repository.mapper;
import com.firstProject.model.FavoriteList;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FavoriteListMapper implements RowMapper<FavoriteList> {

    @Override
    public FavoriteList mapRow(ResultSet rs, int rowNum) throws SQLException {
        FavoriteList favoriteList = new FavoriteList(
                rs.getLong("favorite_list_id"),
                rs.getLong("customer_id"),
                rs.getLong("item_id")
        );
        return favoriteList;
    }
}
