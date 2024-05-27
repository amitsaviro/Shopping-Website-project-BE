package com.firstProject.repository;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.firstProject.model.OrderItem;

public interface OrderItemRepository {
    Long createOrderItem(OrderItem orderItem)throws JsonProcessingException;
    void updateOrderItem(OrderItem orderItem);
    void deleteOrderItemById(Long id);
    OrderItem getOrderItemById(Long id) throws JsonProcessingException;
    List<OrderItem> getOrderItemsByOrderListId(Long orderListId) throws JsonProcessingException;

}
