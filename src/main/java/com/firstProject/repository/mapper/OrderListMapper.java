package com.firstProject.repository.mapper;
import com.firstProject.model.OrderList;
import com.firstProject.model.OrderStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderListMapper implements RowMapper<OrderList> {

    @Override
    public OrderList mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderList orderList = new OrderList(
                rs.getLong("order_list_id"),
                rs.getLong("customer_id"),
                rs.getString("order_date"),
                rs.getString("shipping_address"),
                rs.getBigDecimal("total_price"),
                OrderStatus.valueOf(rs.getString("status"))
        );
        return orderList;
    }
}