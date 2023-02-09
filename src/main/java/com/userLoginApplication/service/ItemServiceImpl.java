package com.userLoginApplication.service;


import com.userLoginApplication.model.Item;
import com.userLoginApplication.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void createItem(Item item) throws Exception {
        itemRepository.createItem(item);
    }

    @Override
    public Item getItemById(Long itemId) throws Exception {
        return itemRepository.getItemById(itemId);
    }

    @Override
    public void deleteItemById(Long itemId) throws Exception {
        itemRepository.deleteItemById(itemId);
    }

    @Override
    public List<Item> getAllItems() throws Exception {
        return itemRepository.getAllItems();
    }
}
