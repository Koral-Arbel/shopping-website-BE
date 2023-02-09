package com.userLoginApplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLoginApplication.model.*;
import com.userLoginApplication.model.Item;
import com.userLoginApplication.model.OrderList;
import com.userLoginApplication.model.UserOrder;
import com.userLoginApplication.repository.OrderListRepository;
import com.userLoginApplication.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private OrderListRepository orderListRepository;
    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;


    @Override
    public void createOrder(UserOrder userOrder) throws Exception {
        List<OrderList> orderLists = new ArrayList<>(orderListRepository.getAllOrdersByUsername(userOrder.getUsername()));
        List<Item> orderItemlist = new ArrayList<>();
        Long totalPrice = null;
        for (int i = 0; i < orderLists.size(); i++) {
            orderItemlist.add(itemService.getItemById(orderLists.get(i).getItemId()));
            totalPrice += orderItemlist.get(i).getPrice();
        }
        String shippingAddress = (userService.findUserByUsername(userOrder.getUsername()).getUsername()) + " " + (userService.findUserByUsername(userOrder.getUsername()).getActive());
        UserOrder newUserOrder = new UserOrder(null, userOrder.getUsername(), userOrder.getDate(), totalPrice, shippingAddress, OrderStatus.valueOf("CLOSE"));
        userOrderRepository.createOrder(newUserOrder);
        System.out.println(totalPrice);
    }

    @Override
    public UserOrder getOrderById(String username, Long orderId) {
        return userOrderRepository.getOrderById(username,orderId);    }

    @Override
    public void updateOrderById(Long orderId, UserOrder userOrder) throws Exception {
        if (userOrderRepository.getOrderById(userOrder.getUsername(), orderId) != null)
        {
            userOrderRepository.updateOrderById(orderId,userOrder);
        } else {
            throw new Exception("No such order to update");
        }
    }

    @Override
    public void deleteOrderById(Long orderId, String username) throws Exception {
        if (userOrderRepository.getOrderById(username, orderId) == null) {
            throw new Exception("No such order exist");
        } else {
            userOrderRepository.deleteOrderById(orderId);
        }
    }
    @Override
    public List<UserOrder> getAllOrdersById(String username) throws Exception {
        if (userOrderRepository.getAllOrdersById(username) != null)
        {
            return userOrderRepository.getAllOrdersById(username);
        } else {
            throw new Exception("No such order");
        }
    }
}