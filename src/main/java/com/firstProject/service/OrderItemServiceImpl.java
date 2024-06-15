package com.firstProject.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.OrderItem;
import com.firstProject.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Long createOrderItem(OrderItem orderItem) throws JsonProcessingException {
        return orderItemRepository.createOrderItem(orderItem);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        orderItemRepository.updateOrderItem(orderItem);
    }

    @Override
    public void deleteOrderItemById(Long id) {
        orderItemRepository.deleteOrderItemById(id);
    }

    @Override
    public OrderItem getOrderItemById(Long id) throws JsonProcessingException {
        return orderItemRepository.getOrderItemById(id);
    }
    @Override
    public List<OrderItem> getOrderItemsByOrderListId(Long orderId) throws JsonProcessingException{
        return orderItemRepository.getOrderItemsByOrderListId(orderId);
    }
    @Override
    public void deleteAllOrderItemByOrderListId(Long orderId){
       orderItemRepository.deleteAllOrderItemByOrderListId(orderId);
    }
}
