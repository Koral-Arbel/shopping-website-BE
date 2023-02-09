package com.userLoginApplication.model;

public class OrderList {
    private Long orderListId;
    private String username;
    private Long itemId;
    private Long quantityItem;

    public OrderList(Long orderListId, String username, Long itemId, Long quantityItem) {
        this.orderListId = orderListId;
        this.username = username;
        this.itemId = itemId;
        this.quantityItem = quantityItem;
    }

    public Long getOrderListId() {
        return orderListId;
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

    public void setOrderListId(Long orderListId) {
        this.orderListId = orderListId;
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
