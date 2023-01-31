package com.userLoginApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLoginApplication.model.Item;
import com.userLoginApplication.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public void createItem(Item item) throws Exception {

    }

    @Override
    public void updateItemById(Long itemId, Item item) throws Exception {

    }

    @Override
    public void deleteItemById(Long id) throws Exception {

    }

    @Override
    public Item getItemById(Long id) throws JsonProcessingException {
        return null;
    }

    @Override
    public List<Item> getItemByName(String itemName) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }
}
