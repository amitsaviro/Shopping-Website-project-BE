package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.OrderList;
import com.firstProject.repository.OrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService{
    @Autowired
    private OrderListRepository orderListRepository;

    @Override
    public ResponseEntity<Long> createOrderList(OrderList orderList) throws Exception {
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
    @Override
    public List<OrderList> getOrderListByCustomerId(Long customerId) throws JsonProcessingException{
        return orderListRepository.getOrderListByCustomerId(customerId);

    }
    @Override
    public OrderList getTempOrderListByCustomerId(Long customerId) throws JsonProcessingException{
        return orderListRepository.getTempOrderListByCustomerId(customerId);
    }

}

