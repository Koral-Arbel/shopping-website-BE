package com.userLoginApplication.service;

public interface UserOrder {
    void createUserOrder(UserOrder userOrder);
    void updateUserOrder(Long userOrderId, UserOrder userOrder) throws Exception;
    void deleteUserOrder(Long userOrderId) throws Exception;
    UserOrder getUserOrder(Long userOrderId);
}
