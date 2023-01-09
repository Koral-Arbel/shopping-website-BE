package com.userLoginApplication.controller;

import com.userLoginApplication.model.UserOrder;
import com.userLoginApplication.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    @PostMapping(value = "/userOrder/create")
    public void createCustomerOrder(@RequestBody UserOrder userOrder) throws Exception {
        userOrderService.createUserOrder(userOrder);
    }

    @PutMapping(value = "/userOrder/{userOrderId}/update")
    public void updateUserOrderById(@PathVariable Long userOrderId,
                                    @RequestBody UserOrder userOrder) throws Exception {
        userOrderService.updateUserOrderById(userOrderId, userOrder);
    }

    @DeleteMapping(value = "/userOrder/{userOrderId}/delete")
    public void deleteUserOrderById(@PathVariable Long userOrderId) throws Exception {
        userOrderService.deleteUserOrderById(userOrderId);
    }

    @GetMapping(value = "/userOrder/{userOrderId}")
    public UserOrder getUserOrderById(@PathVariable Long orderId) {
        return userOrderService.getUserOrderById(orderId);
    }
}