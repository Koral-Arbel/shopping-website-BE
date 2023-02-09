package com.userLoginApplication.service;

import com.userLoginApplication.model.Item;
import com.userLoginApplication.model.OrderList;

import java.util.List;

public interface OrderListService {
    void createOrderList(OrderList orderList)throws Exception;
    void deleteItemInList(String username,Long itemId) throws Exception;
    void deleteList(String username) throws Exception;
    List<Item> getAllOrdersByUserId(String username)throws Exception;
}
