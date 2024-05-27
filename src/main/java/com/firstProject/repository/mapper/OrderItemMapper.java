package com.firstProject.repository.mapper;
import com.firstProject.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderItemMapper implements RowMapper<OrderItem> {

    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderItem orderItem = new OrderItem(
                rs.getLong("order_item_id"),
                rs.getLong("order_id"),
                rs.getLong("item_id"),
                rs.getLong("quantity")
        );
        return orderItem;
    }
}