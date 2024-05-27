package com.firstProject.repository;

import antlr.collections.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.OrderItem;
import com.firstProject.model.OrderList;

public interface OrderListRepository {
    Long createOrderList(OrderList orderList)throws JsonProcessingException;
    void updateOrderList(OrderList orderList);
    void deleteOrderListById(Long id);
    OrderList getOrderListById(Long id) throws JsonProcessingException;
}
