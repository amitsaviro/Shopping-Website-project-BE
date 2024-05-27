package com.firstProject.model;
import java.math.BigDecimal;


public class OrderList {
    private Long orderListId;
    private Long customerId;
    private String orderDate;
    private String shippingAddress;
    private BigDecimal totalPrice;
    private OrderStatus status;

    public OrderList() {
    }

    public OrderList(Long orderListId ,Long customerId, String orderDate, String shippingAddress, BigDecimal totalPrice, OrderStatus status) {
        this.orderListId=orderListId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Long orderListId) {
        this.orderListId = orderListId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

