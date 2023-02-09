package com.userLoginApplication.repository;

import com.userLoginApplication.model.UserOrder;

import java.util.List;

public interface UserOrderRepository {
    void createOrder(UserOrder userOrder);
    UserOrder getOrderById(String username, Long orderId);
    void updateOrderById(Long orderId,UserOrder userOrder);
    void deleteOrderById(Long orderId);
    List<UserOrder> getAllOrdersById(String username);
}
