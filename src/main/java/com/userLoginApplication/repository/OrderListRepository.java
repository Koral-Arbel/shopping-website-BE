package com.userLoginApplication.repository;

import com.userLoginApplication.model.OrderList;

import java.util.List;

public interface OrderListRepository {
    void createOrderList(OrderList orderList);
    void deleteList(String username);
    void deleteItemInList(String username,Long itemId);
    List<OrderList> getAllOrdersByUsername(String username);
}
