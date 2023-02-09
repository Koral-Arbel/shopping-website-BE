package com.userLoginApplication.repository.mapper;

import com.userLoginApplication.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Item(
                rs.getLong("item_id"),
                rs.getString("title"),
                rs.getLong("price"),
                rs.getString("image"),
                rs.getLong("quantity_available")
        );
    }
}
