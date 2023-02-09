package com.userLoginApplication.model;

public class Favorite {
    private Long favoriteId;
    private Long userId;

    public Favorite(Long favoriteId, Long userId) {
        this.favoriteId = favoriteId;
        this.userId = userId;
    }

    public Long getFavoriteId() {
        return favoriteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
