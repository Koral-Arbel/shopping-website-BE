package com.userLoginApplication.model;

import java.time.LocalDate;

public class UserOrder {
    private Long orderId;
    private Long orderUserId;
    private LocalDate orderDate;
    private String shippingAddress;
    private Double totalPrice;
    private OrderStatus orderStatus;

    public UserOrder(Long orderId, Long orderUserId, LocalDate orderDate, String shippingAddress, Double totalPrice, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.orderUserId = orderUserId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getOrderUserId() {
        return orderUserId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderUserId(Long orderUserId) {
        this.orderUserId = orderUserId;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
