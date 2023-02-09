package com.userLoginApplication.model;

import java.sql.Date;

public class UserOrder {
    private Long id;
    private String username;
    private Date date;
    private Long totalPrice;
    private String shippingAddress;
    private OrderStatus orderStatus;

    public UserOrder(Long id, String username, Date date, Long totalPrice, String shippingAddress, OrderStatus orderStatus) {
        this.id = id;
        this.username = username;
        this.date = date;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Date getDate() {
        return date;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
