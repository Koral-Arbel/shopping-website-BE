package com.userLoginApplication.repository.mapper;

import com.userLoginApplication.model.OrderList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderListMapper implements RowMapper<OrderList> {

    @Override
    public OrderList mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OrderList(
                rs.getLong("order_list_id"),
                rs.getString("username"),
                rs.getLong("item_id"),
                rs.getLong("quantity_item")
        );
    }
}
