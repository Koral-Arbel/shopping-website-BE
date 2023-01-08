package com.userLoginApplication.repository.mapper;

import com.userLoginApplication.model.User;
import com.userLoginApplication.model.UserStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("user_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("country"),
                rs.getString("city"),
                UserStatus.valueOf(rs.getString("user_status"))
        );
    }
}
