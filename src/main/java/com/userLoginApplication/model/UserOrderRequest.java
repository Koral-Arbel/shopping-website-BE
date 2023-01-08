package com.userLoginApplication.model;

public class UserOrderRequest {
    private User user;
    private UserOrder userOrder;

    public UserOrderRequest(User user, UserOrder userOrder) {
        this.user = user;
        this.userOrder = userOrder;
    }

    public User getUser() {
        return user;
    }

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    //building the userOrder DTO
    public UserOrder toUserOrder(){
        return new UserOrder(
                this.userOrder.getOrderId(),
                this.user.getUserId(),
                this.userOrder.getOrderDate(),
                this.userOrder.getShippingAddress(),
                this.userOrder.getTotalPrice(),
                this.userOrder.getOrderStatus()
        );
    }
}
