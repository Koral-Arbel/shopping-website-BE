package com.userLoginApplication.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLoginApplication.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl implements ItemRepository {


    @Override
    public void createItem(Item item) {

    }

    @Override
    public void updateItemById(Long itemId, Item item) {

    }

    @Override
    public void deleteItemById(Long id) {

    }

    @Override
    public Item getItemById(Long id) throws JsonProcessingException {
        return null;
    }
}
