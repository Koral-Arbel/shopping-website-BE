package com.userLoginApplication.controller;


import com.userLoginApplication.model.FavoriteList;
import com.userLoginApplication.model.Item;
import com.userLoginApplication.model.OrderList;
import com.userLoginApplication.service.FavoriteListService;
import com.userLoginApplication.service.ItemService;
import com.userLoginApplication.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ecommerce/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private FavoriteListService favoriteListService;

    @GetMapping(value = "/getAll")
    @CrossOrigin
    public List<Item> getItemlist() throws Exception {
        return itemService.getAllItems();
    }

    @GetMapping(value = "/get")
    @CrossOrigin
    public Item getItem(@RequestParam Long itemId) throws Exception {
        return itemService.getItemById(itemId);
    }

    @PostMapping(value = "/order/add")
    @CrossOrigin
    public void addItemToOrder(@RequestBody OrderList orderList) throws Exception {
        orderListService.createOrderList(orderList);
    }

    @DeleteMapping(value = "/order/delete")
    @CrossOrigin
    public void deleteItemFromOrder(@RequestParam String username, Long itemId) throws Exception {
        orderListService.deleteItemInList(username, itemId);
    }

    @DeleteMapping(value = "/order/list/delete")
    @CrossOrigin
    public void deleteList(@RequestParam String username) throws Exception {
        orderListService.deleteList(username);
    }

    @PostMapping(value = "/favorite/add")
    @CrossOrigin
    public void addItemToFavorite(@RequestBody FavoriteList favoriteList) throws Exception {
        favoriteListService.createFavoriteList(favoriteList);
    }

    @DeleteMapping(value = "/favorite/delete")
    @CrossOrigin
    public void deleteItemFromOrder(@RequestBody FavoriteList favoriteList) throws Exception {
        favoriteListService.deleteItemInFavoriteList(favoriteList);
    }

    @DeleteMapping(value = "/favorite/list/delete")
    @CrossOrigin
    public void deleteFavList(@RequestParam String username) throws Exception {
        favoriteListService.deleteFavoriteList(username);
    }

    @GetMapping(value = "/order/get/list")
    @CrossOrigin
    public List<Item> getItemsByUser(@RequestParam String username) throws Exception {
        return orderListService.getAllOrdersByUserId(username);
    }


    @GetMapping(value = "/favorite/get/list")
    @CrossOrigin
    public List<Item> getFaItemsByUser(@RequestParam String username)throws Exception{
        return favoriteListService.getAllFavoriteListByFavoriteId(username);
    }
}

