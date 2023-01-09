package com.userLoginApplication.service;

import com.userLoginApplication.model.UserOrder;

public interface UserOrderService {
    void createUserOrder(UserOrder userOrder) throws Exception;
    void updateUserOrderById(Long userOrderId, UserOrder userOrder) throws Exception;
    void deleteUserOrderById(Long orderId) throws Exception;
    UserOrder getUserOrderById(Long orderId);

}
