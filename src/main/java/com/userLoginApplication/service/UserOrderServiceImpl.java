package com.userLoginApplication.service;

import com.userLoginApplication.model.UserOrder;
import com.userLoginApplication.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserOrderRepository userOrderRepository;

    @Override
    public void createUserOrder(UserOrder userOrder) throws Exception {
        userOrderRepository.createUserOrder(userOrder);
    }

    @Override
    public void updateUserOrderById(Long userOrderId, UserOrder userOrder) throws Exception {
        userOrderRepository.updateUserOrderById(userOrderId, userOrder);
    }

    @Override
    public void deleteUserOrderById(Long orderId) throws Exception {
        userOrderRepository.deleteUserOrderById(orderId);
    }

    @Override
    public UserOrder getUserOrderById(Long userOrderId) {
       return userOrderRepository.getUserOrderById(userOrderId);
    }
}
