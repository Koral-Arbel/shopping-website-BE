package com.userLoginApplication.service;

import com.userLoginApplication.model.UserOrder;
import com.userLoginApplication.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    UserService userService;


    @Override
    public void createUserOrder(UserOrder userOrder) throws Exception {
//        User selectedUser = userOrderRequest.getUser();
//        User userForResponse = null;
//        System.out.println("1");
//        if (selectedUser != null) {
//            System.out.println("2");
//            if(selectedUser.getUserId() != null ){
//                System.out.println("3");
//                User existingUser = userService.getUserById(selectedUser.getUserId());
//                if (existingUser != null){
//                    System.out.println("4");
//                    //create new user order and associate to user
//                    userOrderRepository.createUserOrder(userOrderRequest.toUserOrder());
//                    userForResponse = existingUser;
//                } else {
//                    System.out.println("5");
//                    throw new Exception("Can't create userOrder with non existing user id: " + selectedUser.getUserId());
//                }
//            } else {
//                System.out.println("6");
//
//                return null;
//            }
//
//        } else {
//            System.out.println("7");
//            throw new Exception("Cant create userOrder with user as null");
//        }
//        System.out.println("8");
//        List<UserOrder> userOrderList = userOrderRepository.getUserOrderByUserId(userForResponse.getUserId());
//        return userOrderRequest.getUserOrder().toUserOrderResponse(userForResponse, userOrderList);
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
