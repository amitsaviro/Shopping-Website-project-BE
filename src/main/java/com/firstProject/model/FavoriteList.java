package com.firstProject.model;

public class FavoriteList {
    private Long favoriteListId;
    private Long customerId;
    private Long itemId;

    public FavoriteList() {
    }

    public FavoriteList(Long favoriteListId, Long customerId, Long itemId) {
        this.favoriteListId=favoriteListId;
        this.customerId = customerId;
        this.itemId = itemId;
    }

    public Long getFavoriteListId() {
        return favoriteListId;
    }

    public void setFavoriteListId(Long favoriteListId) {
        this.favoriteListId = favoriteListId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}

