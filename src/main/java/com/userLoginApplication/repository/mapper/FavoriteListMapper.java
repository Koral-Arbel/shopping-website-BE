package com.userLoginApplication.repository.mapper;

import com.userLoginApplication.model.FavoriteList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteListMapper implements RowMapper<FavoriteList> {
    @Override
    public FavoriteList mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FavoriteList(
                rs.getLong("order_list_id"),
                rs.getString("username"),
                rs.getLong("item_id"),
                rs.getLong("quantity_item")
        );
    }
}
