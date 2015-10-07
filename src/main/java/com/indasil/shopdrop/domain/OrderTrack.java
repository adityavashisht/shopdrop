package com.indasil.shopdrop.domain;

import java.util.Date;

/**
 * Created by vashishta on 10/5/15.
 */
public class OrderTrack {

    private Long id;
    // many to one
    private Order order;
    // many to one
    private OrderStatus orderStatus;

    private Date trackingDate;
    private Boolean current;

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getTrackingDate() {
        return trackingDate;
    }

    public void setTrackingDate(Date trackingDate) {
        this.trackingDate = trackingDate;
    }
}
