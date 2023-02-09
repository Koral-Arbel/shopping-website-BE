package com.userLoginApplication.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLoginApplication.model.Item;
import com.userLoginApplication.model.OrderList;
import com.userLoginApplication.repository.ItemRepository;
import com.userLoginApplication.repository.OrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService{
    @Autowired
    private OrderListRepository orderListRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createOrderList(OrderList orderList) throws Exception {
        orderListRepository.createOrderList(orderList);

    }

    @Override
    public void deleteItemInList(String username, Long itemId) throws Exception {
        orderListRepository.deleteItemInList(username,itemId);

    }

    @Override
    public void deleteList(String username) throws Exception {
        orderListRepository.deleteList(username);

    }

    @Override
    public List<Item> getAllOrdersByUserId(String username) throws Exception {
        List<Item> orderItem = new ArrayList<>();
        List<OrderList> orderList = new ArrayList<>(orderListRepository.getAllOrdersByUsername(username));
        for (int i = 0; i < orderList.size(); i++) {
            orderItem.add(itemRepository.getItemById(orderList.get(i).getItemId()));
        }
        return orderItem;
    }
}
