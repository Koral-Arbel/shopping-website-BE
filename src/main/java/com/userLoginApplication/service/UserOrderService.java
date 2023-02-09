package com.userLoginApplication.service;

import com.userLoginApplication.model.UserOrder;

import java.util.List;

public interface UserOrderService {
    void createOrder(UserOrder userOrder)throws Exception;
    UserOrder getOrderById(String username,Long orderId);
    void updateOrderById(Long orderId,UserOrder userOrder) throws Exception;
    void deleteOrderById(Long orderId,String username) throws Exception;
    List<UserOrder> getAllOrdersById(String username)throws Exception;
}
