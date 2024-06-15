package com.firstProject.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Item;
import com.firstProject.model.OrderItem;

public interface OrderItemService {
    Long createOrderItem(OrderItem orderItem) throws JsonProcessingException;
    void updateOrderItem(OrderItem orderItem);
    void deleteOrderItemById(Long id);
    OrderItem getOrderItemById(Long id) throws JsonProcessingException;
    List<OrderItem> getOrderItemsByOrderListId(Long orderId) throws JsonProcessingException;
    void deleteAllOrderItemByOrderListId(Long orderId);
}
