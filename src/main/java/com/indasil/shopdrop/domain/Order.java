package com.indasil.shopdrop.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by vashishta on 10/5/15.
 */
public class Order {

    private Long id;
    private Date createDate;
    private Customer customer;


    private List<OrderTrack> orderTracks;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private List<OrderItem> orderItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
