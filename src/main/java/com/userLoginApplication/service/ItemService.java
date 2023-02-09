package com.userLoginApplication.service;

import com.userLoginApplication.model.Item;

import java.util.List;

public interface ItemService {
    void createItem(Item item)throws Exception;
    Item getItemById(Long itemId) throws Exception;
    void deleteItemById(Long itemId) throws Exception;
    List<Item> getAllItems()throws Exception;
}
