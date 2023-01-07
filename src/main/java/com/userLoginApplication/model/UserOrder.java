package com.userLoginApplication.model;

import java.time.LocalDate;

public class UserOrder {
    private Long orderId;
    private Long userOrderId;
    private LocalDate orderDate;
    private String shippingAddress;
    private Long totalPrice;
    private OrderStatus orderStatus;

    public UserOrder(Long orderId, Long userOrderId, LocalDate orderDate, String shippingAddress, Long totalPrice, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.userOrderId = userOrderId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserOrderId() {
        return userOrderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setUserOrderId(Long userOrderId) {
        this.userOrderId = userOrderId;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}