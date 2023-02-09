package com.userLoginApplication.service;

import com.userLoginApplication.repository.FavoriteRepository;
import com.userLoginApplication.security.model.Favorite;
import com.userLoginApplication.security.model.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService{
    @Autowired
    private FavoriteRepository favouriteRepository;

    @Override
    public void createFavorite(String username) throws Exception {
        favouriteRepository.createFavourite(username);

    }

    @Override
    public Favorite getFavoriteById(Long favoriteId) throws Exception {
        return favouriteRepository.getFavouriteById(favoriteId);
    }

    @Override
    public void updateFavoriteById(Long favoriteId, Favorite favorite) throws Exception {

    }

    @Override
    public void deleteFavoriteById(Long favoriteId) throws Exception {
        favouriteRepository.deleteFavouriteById(favoriteId);
    }

    @Override
    public List<Favorite> getAllFavoritesById(String username) throws Exception {
        return favouriteRepository.getAllFavouritesByUserId(username);
    }
}
