package com.firstProject.model;

import java.math.BigDecimal;

public class Item {
    private Long itemId;
    private String itemName;
    private BigDecimal price;
    private BigDecimal oldPrice;
    private String imgUrl;
    private String category;
    private Long stock;

    public Item(){}

    public Item(Long itemId ,String itemName, BigDecimal price, BigDecimal oldPrice, String imgUrl, String category, Long stock) {
        this.itemId=itemId;
        this.itemName = itemName;
        this.price = price;
        this.oldPrice=oldPrice;
        this.imgUrl=imgUrl;
        this.category=category;
        this.stock=stock;
    }

    public Long getItemId() {
        return itemId;
    }
    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getCategory() {
        return category;
    }

    public Long getStock() {
        return stock;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
