package com.userLoginApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLoginApplication.model.Item;

import java.util.List;

public interface ItemService {
    void createItem(Item item) throws Exception;
    void updateItemById(Long itemId, Item item) throws Exception;
    void deleteItemById(Long id) throws Exception;
    Item getItemById(Long id) throws JsonProcessingException;
    List<Item> getItemByName(String itemName);
    List<Item> getAllItems();
//    List<Long> getItemIdByAvailability(String availability);
}
