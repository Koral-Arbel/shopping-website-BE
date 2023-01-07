package com.userLoginApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLoginApplication.model.UserOrder;

import java.util.List;

public interface UserOrderService {
    void createUserOrder(UserOrder userOrder) throws Exception;
    void updateUserOrderById(Long userOrderId, UserOrder userOrder) throws Exception;
    void deleteUserOrderById(Long orderId) throws Exception;
    UserOrder getUserOrderById(Long orderId);

}
