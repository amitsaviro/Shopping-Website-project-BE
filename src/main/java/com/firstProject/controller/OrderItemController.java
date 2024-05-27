package com.firstProject.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.OrderItem;
import com.firstProject.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http:localhost:3000")

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public void createOrderItem(@RequestBody OrderItem orderItem) throws JsonProcessingException {
        orderItemService.createOrderItem(orderItem);
    }

    @PutMapping("/update")
    public void updateOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.updateOrderItem(orderItem);
    }

    @DeleteMapping("/delete/{orderItemId}")
    public void deleteOrderItemById(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItemById(orderItemId);
    }

    @GetMapping("get/{orderItemId}")
    public OrderItem getOrderItemById(@PathVariable Long orderItemId) throws JsonProcessingException {
        return orderItemService.getOrderItemById(orderItemId);
    }

    @GetMapping("getAllItemsByOrderListId/{orderListId}")
    public List<OrderItem> getOrderItemsByOrderListId(@PathVariable Long orderListId) throws JsonProcessingException {
        return orderItemService.getOrderItemsByOrderListId(orderListId);
    }
}

