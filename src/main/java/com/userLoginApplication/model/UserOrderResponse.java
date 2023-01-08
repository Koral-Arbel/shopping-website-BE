package com.userLoginApplication.model;

import java.util.List;

public class UserOrderResponse {
    private User user;
    private List<UserOrder> userOrders;

    public UserOrderResponse(User user, List<UserOrder> userOrders) {
        this.user = user;
        this.userOrders = userOrders;
    }

    public User getUser() {
        return user;
    }

    public List<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }
}
