package com.userLoginApplication.repository.mapper;

import com.userLoginApplication.model.OrderStatus;
import com.userLoginApplication.model.UserOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOrderMapper implements RowMapper<UserOrder> {

    @Override
    public UserOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserOrder(
                rs.getLong("order_id"),
                rs.getLong("order_user_id"),
                rs.getDate("order_date").toLocalDate(),
                rs.getString("shipping_address"),
                rs.getLong("total_price"),
                OrderStatus.valueOf(rs.getString("order_status"))
                );
    }
}
