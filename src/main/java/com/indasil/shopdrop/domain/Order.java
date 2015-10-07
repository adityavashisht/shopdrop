package com.indasil.shopdrop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vashishta on 10/5/15.
 */
public class Order {

    private Long id;
    private Date createDate;


    // Many to one
    private Customer customer;

    // One to many
    private List<OrderTrack> orderTracks;

    //
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



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

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }
}
