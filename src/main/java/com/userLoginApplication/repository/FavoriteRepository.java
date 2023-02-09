package com.userLoginApplication.repository;

import com.userLoginApplication.security.model.Favorite;

import java.util.List;

public interface FavoriteRepository {
    void createFavourite(String username);
    Favorite getFavouriteById(Long favouriteId);
    void deleteFavouriteById(Long favouriteId);
    List<Favorite> getAllFavouritesByUserId(String username);
}
