package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.OrderList;
import com.firstProject.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http:localhost:3000")

@RestController
@RequestMapping("/orderList")
public class OrderListController {
    @Autowired
    private OrderListService orderListService;

    @PostMapping("/create")
    public ResponseEntity<Long> createOrderList(@RequestBody OrderList orderList) throws Exception {
        return orderListService.createOrderList(orderList);
    }


    @PutMapping("/update")
    public void updateOrderList(@RequestBody OrderList orderList) {
        orderListService.updateOrderList(orderList);
    }

    @DeleteMapping("/delete/{orderListId}")
    public void deleteOrderListById(@PathVariable Long orderListId) {
        orderListService.deleteOrderListById(orderListId);
    }

    @GetMapping("/get/{orderListId}")
    public OrderList getOrderListById(@PathVariable Long orderListId) throws JsonProcessingException {
        return orderListService.getOrderListById(orderListId);
    }

    @GetMapping("/getOrderListByCustomer/{customerId}")
    public List<OrderList> getOrderListByCustomerId(@PathVariable Long customerId) throws JsonProcessingException {
        return orderListService.getOrderListByCustomerId(customerId);
    }
    @GetMapping("/getTEMPorder/{customerId}")
    public OrderList getTempOrderListByCustomerId(@PathVariable Long customerId) throws JsonProcessingException {
        return orderListService.getTempOrderListByCustomerId(customerId);
    }
}
