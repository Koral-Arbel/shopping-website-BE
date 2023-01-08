package com.userLoginApplication.service;

import com.userLoginApplication.model.User;
import com.userLoginApplication.model.UserOrder;
import com.userLoginApplication.model.UserOrderRequest;
import com.userLoginApplication.model.UserOrderResponse;
import com.userLoginApplication.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    UserService userService;


    @Override
    public UserOrderResponse createUserOrder(UserOrderRequest userOrderRequest) throws Exception {
        User selectedUser = userOrderRequest.getUser();
        User userForResponse = null;
        if (selectedUser != null) {
            if(selectedUser.getUserId() != null ){
                User existingUser = userService.getUserById(selectedUser.getUserId());
                if (existingUser != null){
                    //create new user order and associate to user
                    userOrderRepository.createUserOrder(userOrderRequest.toUserOrder());
                    userForResponse = existingUser;
                } else {
                    throw new Exception("Can't create userOrder with non existing user id: " + selectedUser.getUserId());
                }
            } else {
                Long createdUserId = userService.createUser(selectedUser);
                UserOrder userOrderToCreate = userOrderRequest.toUserOrder();
                userOrderToCreate.setUserOrderId(createdUserId);
                userOrderRepository.createUserOrder(userOrderToCreate);
                userForResponse = userService.getUserById(createdUserId);
            }

        } else {
            throw new Exception("Cant create userOrder with user as null");
        }
        List<UserOrder> userOrderList = userOrderRepository.getUserOrderByUserId(userForResponse.getUserId());
        return userOrderRequest.getUserOrder().toUserOrderResponse(userForResponse, userOrderList);
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
