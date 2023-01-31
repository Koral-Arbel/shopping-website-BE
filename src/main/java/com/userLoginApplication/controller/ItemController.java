package com.userLoginApplication.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLoginApplication.model.Item;
import com.userLoginApplication.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;



    @PostMapping(value = "/item/createItem")
    public void createItem (@RequestBody Item item) throws Exception {
        itemService.createItem(item);
    }

    @PutMapping(value = "/item/{itemId}/update")
    public void updateItemById(@PathVariable Long itemId,
                               @RequestBody Item item) throws Exception {
        itemService.updateItemById(itemId, item);
    }

    @DeleteMapping(value = "/item/{itemId}/delete")
    public void deleteItemById (@PathVariable Long itemId) throws Exception {
        itemService.deleteItemById(itemId);
    }

    @GetMapping(value = "/item/{ItemId}")
    public Item getItemById (@PathVariable Long itemId) throws JsonProcessingException {
        return itemService.getItemById(itemId);
    }
}

