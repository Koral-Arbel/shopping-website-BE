package com.userLoginApplication.service;

import com.userLoginApplication.security.model.Favorite;

import java.util.List;

public interface FavoriteService {
    void createFavorite(String username)throws Exception;
    Favorite getFavoriteById(Long favoriteId) throws Exception;
    void updateFavoriteById(Long favoriteId, Favorite favorite) throws Exception;
    void deleteFavoriteById(Long favoriteId) throws Exception;
    List<Favorite> getAllFavoritesById(String username)throws Exception;
}

