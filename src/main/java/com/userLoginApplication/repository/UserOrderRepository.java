package com.userLoginApplication.repository;

import com.userLoginApplication.model.UserOrder;

import java.util.List;

public interface UserOrderRepository {
    void createUserOrder(UserOrder userOrder) throws Exception;
    void updateUserOrderById(Long userOrderId, UserOrder userOrder) throws Exception;
    void deleteUserOrderById(Long orderId) throws Exception;
    UserOrder getUserOrderById(Long orderId);;
    List<UserOrder> getUserOrderByUserId(Long userId);
}
