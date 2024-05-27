package com.firstProject.repository.mapper;

import com.firstProject.model.Item;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ItemMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item(
                rs.getLong("item_id"),
                rs.getString("item_name"),
                rs.getBigDecimal("old_price"),
                rs.getBigDecimal("price"),
                rs.getString("img_url"),
                rs.getString("category"),
                rs.getLong("stock")
        );
        return item;
    }
}