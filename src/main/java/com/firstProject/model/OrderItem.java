package com.firstProject.model;

public class OrderItem {
    private Long orderItemId;
    private Long orderId;
    private Long itemId;
    private Long quantity;

    public OrderItem() {
    }

    public OrderItem(Long orderItemId, Long orderId, Long itemId, Long quantity ) {
      this.orderItemId=orderItemId;
      this.orderId=orderId;
      this.itemId=itemId;
      this.quantity=quantity;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
