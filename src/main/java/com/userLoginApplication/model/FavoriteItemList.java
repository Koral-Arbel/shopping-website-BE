package com.userLoginApplication.model;

public class FavoriteItemList {
    private Long favoriteItemId;

    public FavoriteItemList(Long favoriteItemId) {
        this.favoriteItemId = favoriteItemId;
    }

    public Long getFavoriteItemId() {
        return favoriteItemId;
    }

    public void setFavoriteItemId(Long favoriteItemId) {
        this.favoriteItemId = favoriteItemId;
    }
}
