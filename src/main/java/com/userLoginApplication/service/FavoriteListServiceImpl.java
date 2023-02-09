package com.userLoginApplication.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLoginApplication.model.FavoriteList;
import com.userLoginApplication.model.Item;
import com.userLoginApplication.repository.FavoriteListRepository;
import com.userLoginApplication.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteListServiceImpl implements FavoriteListService{
    @Autowired
    private FavoriteListRepository favoriteListRepository;
    @Autowired
    private ItemRepository itemRepository;


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createFavoriteList(FavoriteList favoriteList) throws Exception {
        favoriteListRepository.createFavoriteList(favoriteList);
    }

    @Override
    public void deleteItemInFavoriteList(FavoriteList favoriteList) {
        favoriteListRepository.deleteItemInFavouriteList(favoriteList);
    }

    @Override
    public void deleteFavoriteList(String username) throws Exception {
        favoriteListRepository.deleteFavouriteList(username);
    }

    @Override
    public List<Item> getAllFavoriteListByFavoriteId(String username) throws Exception {
        List<Item> orderItem = new ArrayList<>();
        List<FavoriteList> favouriteLists = new ArrayList<>(favoriteListRepository.getAllFavoriteListByFavoriteId(username));
        for (int i = 0; i < favouriteLists.size(); i++) {
            orderItem.add(itemRepository.getItemById(favouriteLists.get(i).getItemId()));
        }
        return orderItem;
    }
}
