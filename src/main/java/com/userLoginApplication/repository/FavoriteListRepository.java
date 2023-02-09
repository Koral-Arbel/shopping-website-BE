package com.userLoginApplication.repository;

import com.userLoginApplication.model.FavoriteList;

import java.util.List;

public interface FavoriteListRepository {
    void createFavoriteList(FavoriteList favoriteList);
    void deleteItemInFavouriteList(FavoriteList favoriteList);

    void deleteFavouriteList(String username);
    List<FavoriteList> getAllFavoriteListByFavoriteId(String username);
}
