package com.userLoginApplication.model;

public class FavoriteList {
    private Long favoriteId;
    private String username;
    private Long itemId;
    private Long quantityItem;

    public FavoriteList(Long favoriteId, String username, Long itemId, Long quantityItem) {
        this.favoriteId = favoriteId;
        this.username = username;
        this.itemId = itemId;
        this.quantityItem = quantityItem;
    }

    public Long getFavoriteId() {
        return favoriteId;
    }

    public String getUsername() {
        return username;
    }

    public Long getItemId() {
        return itemId;
    }

    public Long getQuantityItem() {
        return quantityItem;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setQuantityItem(Long quantityItem) {
        this.quantityItem = quantityItem;
    }
}
