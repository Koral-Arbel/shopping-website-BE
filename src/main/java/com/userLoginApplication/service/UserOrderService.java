package com.userLoginApplication.service;

import com.userLoginApplication.model.UserOrder;
import com.userLoginApplication.model.UserOrderRequest;
import com.userLoginApplication.model.UserOrderResponse;

public interface UserOrderService {
    UserOrderResponse createUserOrder(UserOrderRequest userOrderRequest) throws Exception;
    void updateUserOrderById(Long userOrderId, UserOrder userOrder) throws Exception;
    void deleteUserOrderById(Long orderId) throws Exception;
    UserOrder getUserOrderById(Long orderId);

}
