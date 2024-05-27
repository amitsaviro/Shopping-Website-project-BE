package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.OrderList;
import com.firstProject.repository.OrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderListServiceImpl implements OrderListService{
    @Autowired
    private OrderListRepository orderListRepository;

    @Override
    public Long createOrderList(OrderList orderList) throws JsonProcessingException {
        orderList.setOrderDate(LocalDate.now().toString());
        return orderListRepository.createOrderList(orderList);
    }

    @Override
    public void updateOrderList(OrderList orderList) {
        orderListRepository.updateOrderList(orderList);
    }

    @Override
    public void deleteOrderListById(Long id) {
        orderListRepository.deleteOrderListById(id);
    }

    @Override
    public OrderList getOrderListById(Long id) throws JsonProcessingException {
        return orderListRepository.getOrderListById(id);
    }
}

