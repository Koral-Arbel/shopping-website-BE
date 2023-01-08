package com.userLoginApplication.repository;

import com.userLoginApplication.model.UserOrder;
import com.userLoginApplication.repository.mapper.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.ZoneId;
import java.util.List;

@Repository
public class UserOrderRepositoryImpl implements UserOrderRepository {

    private static final String USER_ORDER_TABLE_NAME = "user_order";
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createUserOrder(UserOrder userOrder) throws Exception {
        String sql = "INSERT INTO " + USER_ORDER_TABLE_NAME + " (order_user_id, order_date, shipping_address, total_price, order_status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, userOrder.getUserOrderId(), userOrder.getOrderDate(), userOrder.getShippingAddress(), userOrder.getTotalPrice(), userOrder.getOrderStatus().name());
    }

    @Override
    public void updateUserOrderById(Long userOrderId, UserOrder userOrder) throws Exception {
        Date orderDate = (Date) Date.from(userOrder.getOrderDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        String sql = "UPDATE " + USER_ORDER_TABLE_NAME + " SET order_user_id=?, order_date=?, shipping_address=?, total_price=?, order_status=? " +
                "WHERE order_id=?";
        jdbcTemplate.update(sql, userOrder.getUserOrderId(), userOrder.getOrderDate(), userOrder.getShippingAddress(), userOrder.getTotalPrice(), userOrder.getOrderStatus().name(), userOrderId, orderDate);
    }

    @Override
    public void deleteUserOrderById(Long orderId) throws Exception {
        String sql = "DELETE FROM " + USER_ORDER_TABLE_NAME + " WHERE order_id=?";
        jdbcTemplate.update(sql, orderId);
    }

    @Override
    public UserOrder getUserOrderById(Long userOrderId) {
        String sql = "SELECT * FROM " + USER_ORDER_TABLE_NAME + " WHERE order_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserOrderMapper(), userOrderId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<UserOrder> getUserOrderByUserId(Long userId) {
        String sql = "SELECT * FROM " + USER_ORDER_TABLE_NAME + " WHERE order_user_id=?";
        try {
            return jdbcTemplate.query(sql, new UserOrderMapper(), userId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
}
