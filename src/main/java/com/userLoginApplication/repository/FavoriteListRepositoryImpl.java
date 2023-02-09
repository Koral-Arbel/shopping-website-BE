package com.userLoginApplication.repository;


import com.userLoginApplication.model.FavoriteList;
import com.userLoginApplication.repository.mapper.FavoriteListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteListRepositoryImpl implements FavoriteListRepository{
    private static final String FAVORITE_LIST_TABLE_NAME = "favourite_list";

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public void createFavoriteList(FavoriteList favoriteList) {
        String sql = "INSERT INTO " + FAVORITE_LIST_TABLE_NAME + " (username,item_id,quantity_item) VALUES (?,?,?)";
        jdbcTemplate.update(sql, favoriteList.getUsername(), favoriteList.getItemId(), favoriteList.getQuantityItem());

    }

    @Override
    public void deleteItemInFavouriteList(FavoriteList favoriteList) {
        String sql = "DELETE FROM " + FAVORITE_LIST_TABLE_NAME + " WHERE username = ? AND item_id = ?";
        jdbcTemplate.update(sql, favoriteList.getUsername(), favoriteList.getItemId());
    }

    @Override
    public void deleteFavouriteList(String username) {
        String sql = "DELETE FROM " + FAVORITE_LIST_TABLE_NAME + " WHERE username = ?";
        jdbcTemplate.update(sql, username);
    }

    @Override
    public List<FavoriteList> getAllFavoriteListByFavoriteId(String username) {
        String sql = "SELECT * FROM " + FAVORITE_LIST_TABLE_NAME + " WHERE username = ?";
        return jdbcTemplate.query(sql, new FavoriteListMapper(),username);
    }
}
