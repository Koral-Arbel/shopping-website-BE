package com.userLoginApplication.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLoginApplication.model.Item;

public interface ItemRepository {
    void createItem(Item item);
    void updateItemById(Long itemId, Item item);
    void deleteItemById(Long id);
    Item getItemById(Long id) throws JsonProcessingException;
}
