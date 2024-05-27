package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.OrderList;
import com.firstProject.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http:localhost:3000")

@RestController
@RequestMapping("/orderList")
public class OrderListController {
    @Autowired
    private OrderListService orderListService;

    @PostMapping("/create")
    public void createOrderList(@RequestBody OrderList orderList) throws JsonProcessingException {
        orderListService.createOrderList(orderList);
    }

    @PutMapping("/update")
    public void updateOrderList(@RequestBody OrderList orderList){
        orderListService.updateOrderList(orderList);
    }

    @DeleteMapping("/delete/{orderListId}")
    public void deleteOrderListById(@PathVariable Long orderListId){
        orderListService.deleteOrderListById(orderListId);
    }

    @GetMapping("get/{orderListId}")
    public OrderList getOrderListById(@PathVariable Long orderListId) throws JsonProcessingException {
        return orderListService.getOrderListById(orderListId);
    }
}
