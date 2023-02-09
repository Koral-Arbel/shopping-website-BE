package com.userLoginApplication.repository;

import com.userLoginApplication.model.UserOrder;
import com.userLoginApplication.repository.mapper.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserOrderRepositoryImpl implements UserOrderRepository {
    private static final String USER_ORDER_TABLE_NAME = "user_order";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createOrder(UserOrder userOrder) {
        String sql = "INSERT INTO " + USER_ORDER_TABLE_NAME + " (username,order_date,total_price,shipping_address,order_status) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,userOrder.getUsername(),userOrder.getDate(),userOrder.getTotalPrice(),userOrder.getShippingAddress(),userOrder.getOrderStatus());
    }

    @Override
    public UserOrder getOrderById(String username, Long orderId) {
        String sql = "SELECT * FROM " + USER_ORDER_TABLE_NAME + " WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserOrderMapper(), username);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public void updateOrderById(Long orderId, UserOrder userOrder) {
        String sql = "UPDATE " + USER_ORDER_TABLE_NAME + " SET username=?,order_date=?,total_price=?,shipping_address=?,order_status=? " + "WHERE id=?";
        jdbcTemplate.update(sql,userOrder.getUsername(),userOrder.getDate(),userOrder.getTotalPrice(),userOrder.getShippingAddress(),userOrder.getOrderStatus(),orderId);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        String sql = "DELETE FROM " + USER_ORDER_TABLE_NAME + " WHERE username = ?";
        jdbcTemplate.update(sql, orderId);
    }

    @Override
    public List<UserOrder> getAllOrdersById(String username) {
        String sql = "SELECT * FROM " + USER_ORDER_TABLE_NAME + " WHERE username = ?";
        try {
            return jdbcTemplate.query(sql, new UserOrderMapper(), username);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
}