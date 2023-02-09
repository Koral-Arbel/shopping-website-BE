package com.userLoginApplication.model;

public class Item {
    private Long itemId;
    private String title;
    private Long price;
    private String image;
    private Long quantityAvailable;

    public Item(Long itemId, String title, Long price, String image, Long quantityAvailable) {
        this.itemId = itemId;
        this.title = title;
        this.price = price;
        this.image = image;
        this.quantityAvailable = quantityAvailable;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public Long getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public Long getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setQuantityAvailable(Long quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
}
