package com.firstProject.repository;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstProject.model.OrderItem;
import com.firstProject.repository.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private static final String ORDER_ITEM_TABLE_NAME = "order_item";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long createOrderItem(OrderItem orderItem) throws JsonProcessingException{
        String sql = "INSERT INTO " + ORDER_ITEM_TABLE_NAME + " (order_id, item_id, quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, orderItem.getOrderId(), orderItem.getItemId(), orderItem.getQuantity());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        String sql = "UPDATE " + ORDER_ITEM_TABLE_NAME + " SET order_id=?, item_id=?, quantity=? WHERE order_item_id=?";
        jdbcTemplate.update(sql, orderItem.getOrderId(), orderItem.getItemId(), orderItem.getQuantity(), orderItem.getOrderItemId());
    }

    @Override
    public void deleteOrderItemById(Long id) {
        String sql = "DELETE FROM " + ORDER_ITEM_TABLE_NAME + " WHERE order_item_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public OrderItem getOrderItemById(Long id) throws JsonProcessingException {
        String sql = "SELECT * FROM " + ORDER_ITEM_TABLE_NAME + " WHERE order_item_id=?";
        OrderItem orderItem = jdbcTemplate.queryForObject(sql, orderItemMapper, id);
        return orderItem;
    }
    @Override
    public List<OrderItem> getOrderItemsByOrderListId(Long orderId) throws JsonProcessingException {
        String sql = "SELECT * FROM " +ORDER_ITEM_TABLE_NAME + " WHERE order_id=?";
            return jdbcTemplate.query(sql, orderItemMapper, orderId);
    }
    @Override
    public void deleteAllOrderItemByOrderListId(Long orderId) {
        String sql = "DELETE FROM " + ORDER_ITEM_TABLE_NAME + " WHERE order_id=?";
        jdbcTemplate.update(sql, orderId);
    }
}
