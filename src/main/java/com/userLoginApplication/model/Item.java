package com.userLoginApplication.model;

public class Item {
    private Long itemId;
    private String itemName;
    private Long itemPrice;


    public Item(Long itemId, String itemName, Long itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }
}