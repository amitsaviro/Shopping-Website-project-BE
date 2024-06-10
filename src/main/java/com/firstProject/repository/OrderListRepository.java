package com.firstProject.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.OrderItem;
import com.firstProject.model.OrderList;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderListRepository {
    ResponseEntity<Long> createOrderList(OrderList orderList)throws Exception;
    void updateOrderList(OrderList orderList);
    void deleteOrderListById(Long id);
    OrderList getOrderListById(Long id) throws JsonProcessingException;
    List<OrderList> getOrderListByCustomerId(Long customerId) throws JsonProcessingException;
    OrderList getTempOrderListByCustomerId(Long customerId) throws JsonProcessingException;
    }
