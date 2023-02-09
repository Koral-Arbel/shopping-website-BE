package com.userLoginApplication.service;

import com.userLoginApplication.model.FavoriteList;
import com.userLoginApplication.model.Item;

import java.util.List;

public interface FavoriteListService {
    void createFavoriteList(FavoriteList favoriteList)throws Exception;
    void deleteItemInFavoriteList(FavoriteList favoriteList);
    void deleteFavoriteList(String username) throws Exception;
    List<Item> getAllFavoriteListByFavoriteId(String username)throws Exception;
}
